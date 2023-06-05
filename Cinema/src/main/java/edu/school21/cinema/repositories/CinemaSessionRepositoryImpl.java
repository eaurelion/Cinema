package edu.school21.cinema.repositories;

import edu.school21.cinema.models.CinemaSession;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Repository
@Transactional
public class CinemaSessionRepositoryImpl implements CinemaSessionRepository{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<CinemaSession> getAll() {
        return entityManager.createQuery("from CinemaSession", CinemaSession.class).getResultList();
    }

    @Override
    public CinemaSession getCinemaSessionById(Long id) {
        return entityManager.find(CinemaSession.class, id);
    }

    @Override
    public void createCinemaSession(CinemaSession cinemaSession) {
        entityManager.merge(cinemaSession);
    }

    @Override
    public void updateCinemaSession(CinemaSession cinemaSession) {
        entityManager.merge(cinemaSession);
    }

    @Override
    public void deleteCinemaSession(CinemaSession cinemaSession) {
        CinemaSession persistentInstance = entityManager.merge(cinemaSession);
        entityManager.remove(persistentInstance);
    }

    @Override
    public List<CinemaSession> findCinemaSessionByText(String text) {
        List<CinemaSession> sessions = new ArrayList<>();
        for (CinemaSession cinemaSession : getAll())
            if (cinemaSession.getMovie().getTitle().toLowerCase(Locale.ROOT).contains(text.toLowerCase(Locale.ROOT)))
                sessions.add(cinemaSession);
            return sessions;
    }
}
