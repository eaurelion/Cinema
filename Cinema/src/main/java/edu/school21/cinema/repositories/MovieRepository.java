package edu.school21.cinema.repositories;

import edu.school21.cinema.models.Movie;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

@Repository
public interface MovieRepository {
    List<Movie> getAll();
    Movie getMovieById(Long id);
    void createMovie(Movie movie);
    void updateMovie(Movie movie);
    void deleteMovie(Movie movie) throws IOException;
}
