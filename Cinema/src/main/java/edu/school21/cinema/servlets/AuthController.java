package edu.school21.cinema.servlets;

import edu.school21.cinema.models.AuthHistory;
import edu.school21.cinema.models.CinemaUser;
import edu.school21.cinema.models.roles.ERole;
import edu.school21.cinema.services.CinemaUserService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.*;

@Controller
public class AuthController {
    private final String avatarPath;

    private final CinemaUserService cinemaUserService;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public AuthController(String avatarPath, CinemaUserService cinemaUserService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.avatarPath = avatarPath;
        this.cinemaUserService = cinemaUserService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @GetMapping("/auth/login")
    public String login() {
        return "/auth/login";
    }

    @PostMapping("/auth/login")
    public void addAuthHistory(HttpServletRequest request) {
        System.out.println(request.getRemoteAddr());
    }

    @GetMapping("/auth/register")
    public String register(@ModelAttribute ("user")CinemaUser cinemaUser) {
        return "/auth/register";
    }

    @PostMapping("/auth/register")
    public String signUp(@ModelAttribute ("user")CinemaUser cinemaUser, HttpServletRequest request) {
        cinemaUser.setRoles(Collections.singleton(new ERole(1L, "USER")));
        cinemaUser.setAuthHistory(new ArrayList<>());
        cinemaUser.setPassword(bCryptPasswordEncoder.encode(cinemaUser.getPassword()));
        cinemaUser.getAuthHistory().add(new AuthHistory(cinemaUser, "register", new Date().toString(), request.getRemoteAddr()));
        if (cinemaUserService.createCinemaUser(cinemaUser)) {
            HttpSession session = request.getSession();
            session.setAttribute("user", cinemaUserService.getCinemaUserByUserName(cinemaUser.getUsername()));
            return "redirect:/";
        }
        return "redirect:/auth/register";
    }

    @GetMapping("/auth/profile")
    public String profile(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        CinemaUser cinemaUser = cinemaUserService.getCinemaUserByUserName(request.getUserPrincipal().getName());
        try {
            boolean isAddedHistory = (boolean) session.getAttribute("isAddedSession");
        }
        catch (Exception e) {
            session.setAttribute("isAddedSession", true);
            cinemaUser.getAuthHistory().add(new AuthHistory(cinemaUser, "Authorization", new Date().toString(), request.getRemoteAddr()));
            cinemaUserService.updateCinemaUser(cinemaUser);
        }
        model.addAttribute("user", cinemaUserService.getCinemaUserByUserName(request.getUserPrincipal().getName()));
        model.addAttribute("listFiles", fileList(cinemaUser));
        return "/auth/profile";
    }

    @GetMapping("/auth/profile/avatar")
    @ResponseBody
    public byte[] downloadAvatar(Principal principal) throws IOException {
        CinemaUser cinemaUser = cinemaUserService.getCinemaUserByUserName(principal.getName());
        return downloadAvatar(cinemaUser);
    }

    @PostMapping("/auth/profile/avatar")
    public String uploadAvatar(@RequestParam("image") MultipartFile file, Principal principal) throws IOException {
        CinemaUser cinemaUser = cinemaUserService.getCinemaUserByUserName(principal.getName());
        loadAvatar(file, cinemaUser);
        return "redirect:/auth/profile";
    }

    @GetMapping("/auth/profile/photo/{filename}")
    @ResponseBody
    public byte[] getOldAvatar(@PathVariable("filename") String filename, Principal principal) throws IOException {
        CinemaUser cinemaUser = cinemaUserService.getCinemaUserByUserName(principal.getName());
        return downloadImage(cinemaUser, filename);
    }

    @GetMapping("/auth/profile/photo/{filename}/show")
    public String showOldAvatar(@PathVariable("filename") String filename) {
        return "/auth/avatar";
    }

    private void loadAvatar(MultipartFile file, CinemaUser cinemaUser) throws IOException {
        if (file.getBytes().length > 0) {
            File uploadDir = new File(avatarPath + "/" + cinemaUser.getId());
            if (!uploadDir.exists())
            { uploadDir.mkdir(); }
            String uuidFile = FilenameUtils.getBaseName(file.getOriginalFilename());
            String resultFileName = uuidFile + "." + FilenameUtils.getExtension(file.getOriginalFilename());
            file.transferTo(new File(avatarPath + "/" + cinemaUser.getId() + "/" + resultFileName));
        }
    }

    private byte[] downloadImage(CinemaUser cinemaUser, String filename) throws IOException {
        File imagesDir0 = new File(avatarPath);
        if (!imagesDir0.exists())
            imagesDir0.mkdir();
        File imagesDir = new File(avatarPath + "/" + cinemaUser.getId());
        if (!imagesDir.exists())
            imagesDir.mkdir();
        File image = new File(avatarPath + "/" + cinemaUser.getId() + "/" + filename);
        if (image.exists())
        return FileUtils.readFileToByteArray(image);
        return null;
    }

    private byte[] downloadAvatar(CinemaUser cinemaUser) throws IOException {
        File imagesDir0 = new File(avatarPath);
        if (!imagesDir0.exists())
            imagesDir0.mkdir();
        File imagesDir = new File(avatarPath + "/" + cinemaUser.getId());
        if (!imagesDir.exists())
            imagesDir.mkdir();
        File image = new File(avatarPath + "/" + cinemaUser.getId());
        if ((Objects.requireNonNull(image.listFiles()).length != 0)) {
            File[] files = image.listFiles();
            assert files != null;
            Arrays.sort(files, Comparator.comparingLong(File::lastModified));
            return FileUtils.readFileToByteArray(files[files.length - 1]);
        }
        return null;
    }

    private List<String> fileList(CinemaUser cinemaUser) {
        List<String> result = new ArrayList<>();
        File imagesDir0 = new File(avatarPath);
        if (!imagesDir0.exists())
            imagesDir0.mkdir();
        File imagesDir = new File(avatarPath + "/" + cinemaUser.getId());
        if (!imagesDir.exists())
            imagesDir.mkdir();
        File image = new File(avatarPath + "/" + cinemaUser.getId());
        if ((Objects.requireNonNull(image.listFiles()).length != 0)) {
            File[] files = image.listFiles();
            assert files != null;
            Arrays.sort(files, Comparator.comparingLong(File::lastModified));
            for (File file : files)
                result.add(file.getName());
        }
        return result;
    }
}
