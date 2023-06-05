package edu.school21.cinema.services;

import edu.school21.cinema.models.MovieHall;
import edu.school21.cinema.repositories.MovieHallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieHallServiceImpl implements MovieHallService{
    private final MovieHallRepository movieHallRepository;

    @Autowired
    public MovieHallServiceImpl(MovieHallRepository movieHallRepository) {
        this.movieHallRepository = movieHallRepository;
    }

    @Override
    public List<MovieHall> getAll() {
        return movieHallRepository.getAll();
    }

    @Override
    public MovieHall getMovieHallById(Long id) {
        return movieHallRepository.getMovieHallById(id);
    }

    @Override
    public void createMovieHall(MovieHall movieHall) {
        movieHallRepository.createMovieHall(movieHall);
    }

    @Override
    public void updateMovieHall(MovieHall movieHall) {
        movieHallRepository.updateMovieHall(movieHall);
    }

    @Override
    public void deleteMovieHall(MovieHall movieHall) {
        movieHallRepository.deleteMovieHall(movieHall);
    }
}
