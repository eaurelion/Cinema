package edu.school21.cinema.services;

import edu.school21.cinema.models.Movie;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.List;

@Service
public interface MovieService {
    List<Movie> getAll();
    Movie getMovieById(Long id);
    void createMovie(Movie movie);
    void updateMovie(Movie movie);
    void deleteMovie(Movie movie) throws IOException;
}
