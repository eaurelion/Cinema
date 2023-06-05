package edu.school21.cinema.services;

import edu.school21.cinema.models.MovieHall;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MovieHallService {
    List<MovieHall> getAll();
    MovieHall getMovieHallById(Long id);
    void createMovieHall(MovieHall movieHall);
    void updateMovieHall(MovieHall movieHall);
    void deleteMovieHall(MovieHall movieHall);
}
