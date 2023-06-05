package edu.school21.cinema.servlets;

import edu.school21.cinema.models.Movie;
import edu.school21.cinema.services.MovieService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
public class FilmsController {
    private final String uploadPath;

    private final MovieService movieService;

    @Autowired
    public FilmsController(String uploadPath, MovieService movieService) {
        this.uploadPath = uploadPath;
        this.movieService = movieService;
    }

    @GetMapping("/films")
    public String films(Model model, HttpServletRequest request) {
        model.addAttribute("movies", movieService.getAll());
        request.setAttribute("movies", movieService.getAll());
        return "/chat/films";
    }

    @GetMapping("/films/{id}/image")
    @ResponseBody
    public byte[] getContent(@PathVariable("id") String id) {
        try {
            Movie movie = movieService.getMovieById(Long.parseLong(id));
            return FileUtils.readFileToByteArray(new File(uploadPath + "/" + movie.getPosterUrl()));
        } catch (IOException e) {
            return null;
        }
    }

    @GetMapping("/films/{id}/chat")
    public String goChat(@PathVariable("id") String id, Model model, HttpServletRequest request) {
        try {
            if (movieService.getMovieById(Long.parseLong(id)) != null) {
                model.addAttribute("movie", movieService.getMovieById(Long.parseLong(id)));
                model.addAttribute("cinemausername", request.getUserPrincipal().getName());
                return "/chat/chat";
            }
            return "redirect:/";
        } catch (Exception e) {
            return "redirect:/";
        }
    }

}
