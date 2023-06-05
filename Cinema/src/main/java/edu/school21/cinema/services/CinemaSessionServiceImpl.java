package edu.school21.cinema.services;

import edu.school21.cinema.models.CinemaSession;
import edu.school21.cinema.repositories.CinemaSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaSessionServiceImpl implements CinemaSessionService {
    private final CinemaSessionRepository cinemaSessionRepository;

    @Autowired
    public CinemaSessionServiceImpl(CinemaSessionRepository cinemaSessionRepository) {
        this.cinemaSessionRepository = cinemaSessionRepository;
    }

    @Override
    public List<CinemaSession> getAll() {
        return cinemaSessionRepository.getAll();
    }

    @Override
    public CinemaSession getCinemaSessionById(Long id) {
        return cinemaSessionRepository.getCinemaSessionById(id);
    }

    @Override
    public void createCinemaSession(CinemaSession cinemaSession) {
        cinemaSessionRepository.createCinemaSession(cinemaSession);
    }

    @Override
    public void updateCinemaSession(CinemaSession cinemaSession) {
        cinemaSessionRepository.updateCinemaSession(cinemaSession);
    }

    @Override
    public void deleteCinemaSession(CinemaSession cinemaSession) {
        cinemaSessionRepository.deleteCinemaSession(cinemaSession);
    }

    @Override
    public List<CinemaSession> findCinemaSessionByText(String text) {
        return cinemaSessionRepository.findCinemaSessionByText(text);
    }
}
