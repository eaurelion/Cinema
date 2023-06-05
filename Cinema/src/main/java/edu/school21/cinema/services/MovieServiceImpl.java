package edu.school21.cinema.services;

import edu.school21.cinema.models.Movie;
import edu.school21.cinema.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> getAll() {
        return movieRepository.getAll();
    }

    @Override
    public Movie getMovieById(Long id) {
        return movieRepository.getMovieById(id);
    }

    @Override
    public void createMovie(Movie movie) {
        movieRepository.createMovie(movie);
    }

    @Override
    public void updateMovie(Movie movie) {
        movieRepository.updateMovie(movie);
    }

    @Override
    public void deleteMovie(Movie movie) throws IOException {
        movieRepository.deleteMovie(movie);
    }
}
