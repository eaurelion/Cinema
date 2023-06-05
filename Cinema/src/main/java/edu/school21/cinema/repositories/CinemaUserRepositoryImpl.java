package edu.school21.cinema.repositories;

import edu.school21.cinema.models.CinemaUser;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.util.List;

@Repository
@Transactional
public class CinemaUserRepositoryImpl implements CinemaUserRepository {
    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    private EntityManager entityManager;

    @Override
    public List<CinemaUser> getAll() {
        return entityManager.createQuery("from CinemaUser", CinemaUser.class).getResultList();
    }

    @Override
    public CinemaUser getUserById(Long id) {
        return entityManager.find(CinemaUser.class, id);
    }

    @Override
    public boolean createUser(CinemaUser cinemaUser) {
        for (CinemaUser i : getAll())
            if (i.getUsername().equals(cinemaUser.getUsername()))
                return false;
        entityManager.merge(cinemaUser);
        return true;
    }

    @Override
    public void updateUser(CinemaUser cinemaUser) {
        entityManager.merge(cinemaUser);
    }

    @Override
    public void deleteUser(CinemaUser cinemaUser) {
        CinemaUser persistentInstance = entityManager.merge(cinemaUser);
        entityManager.remove(persistentInstance);
    }

    @Override
    public CinemaUser getUserByUsername(String username) {
        for (CinemaUser cinemaUser : getAll())
            if (cinemaUser.getUsername().equals(username))
                return cinemaUser;
        return null;
    }
}
