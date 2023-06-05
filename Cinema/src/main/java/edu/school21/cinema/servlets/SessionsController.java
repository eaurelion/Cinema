package edu.school21.cinema.servlets;

import edu.school21.cinema.models.CinemaSession;
import edu.school21.cinema.models.dao.CinemaSessionDao;
import edu.school21.cinema.services.CinemaSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SessionsController {
    private final CinemaSessionService cinemaSessionService;

    @Autowired
    public SessionsController(CinemaSessionService cinemaSessionService) {
        this.cinemaSessionService = cinemaSessionService;
    }

    @GetMapping("/sessions/search")
    @ResponseBody
    public List<CinemaSessionDao> searchSessions(@RequestParam("filmName") String filmName) {
        List<CinemaSession> cinemaSessions = cinemaSessionService.findCinemaSessionByText(filmName);
        List<CinemaSessionDao> cinemaSessionDaos = new ArrayList<>();
        for (CinemaSession cinemaSession : cinemaSessions)
            cinemaSessionDaos.add(new CinemaSessionDao(cinemaSession));
        return cinemaSessionDaos;
    }

    @GetMapping("/sessions")
    public String sessions() {
        return "/sessions/sessionSearch";
    }

    @GetMapping("/sessions/{id}")
    public String editCinemaSessions(@PathVariable("id") String id, Model model, HttpServletRequest request) {
        try {
            if (cinemaSessionService.getCinemaSessionById(Long.parseLong(id)) != null) {
                model.addAttribute("cinemaSession", cinemaSessionService.getCinemaSessionById(Long.parseLong(id)));
                request.setAttribute("cinemaSession", cinemaSessionService.getCinemaSessionById(Long.parseLong(id)));
                return "/sessions/showSession";
            }
            return "redirect:/sessions";
        } catch (Exception e) {
            return "redirect:/sessions";
        }
    }
}
