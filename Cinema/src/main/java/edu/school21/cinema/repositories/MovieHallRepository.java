package edu.school21.cinema.repositories;

import edu.school21.cinema.models.MovieHall;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieHallRepository {
    List<MovieHall> getAll();
    MovieHall getMovieHallById(Long id);
    void createMovieHall(MovieHall movieHall);
    void updateMovieHall(MovieHall movieHall);
    void deleteMovieHall(MovieHall movieHall);
}
