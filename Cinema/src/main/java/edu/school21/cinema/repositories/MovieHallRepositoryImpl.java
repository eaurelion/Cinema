package edu.school21.cinema.repositories;

import edu.school21.cinema.models.MovieHall;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.util.List;

@Repository
@Transactional
public class MovieHallRepositoryImpl implements MovieHallRepository{
    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    private EntityManager entityManager;

    @Override
    public List<MovieHall> getAll() {
        return entityManager.createQuery("from MovieHall", MovieHall.class).getResultList();
    }

    @Override
    public MovieHall getMovieHallById(Long id) {
        return entityManager.find(MovieHall.class, id);
    }

    @Override
    public void createMovieHall(MovieHall movieHall) {
        entityManager.merge(movieHall);
    }

    @Override
    public void updateMovieHall(MovieHall movieHall) {
        MovieHall temp = entityManager.find(MovieHall.class, movieHall.getId());
        if (temp != null) {
            movieHall.setSessionList(temp.getSessionList());
            entityManager.merge(movieHall);
        }
    }

    @Override
    public void deleteMovieHall(MovieHall movieHall) {
        MovieHall persistentInstance = entityManager.merge(movieHall);
        entityManager.remove(persistentInstance);
    }
}
