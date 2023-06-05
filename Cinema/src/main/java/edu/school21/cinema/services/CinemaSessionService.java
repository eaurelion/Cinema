package edu.school21.cinema.services;

import edu.school21.cinema.models.CinemaSession;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CinemaSessionService {
    List<CinemaSession> getAll();
    CinemaSession getCinemaSessionById(Long id);
    void createCinemaSession(CinemaSession cinemaSession);
    void updateCinemaSession(CinemaSession cinemaSession);
    void deleteCinemaSession(CinemaSession cinemaSession);
    List<CinemaSession> findCinemaSessionByText(String text);
}
