package com.epam.mentoring.flixcore.service.impl;

import com.epam.mentoring.flixcore.model.Movie;
import com.epam.mentoring.flixcore.repository.MovieRepository;
import com.epam.mentoring.flixcore.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    private MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Optional<Movie> createMovie(Movie movie) {
        return Optional.of(movieRepository.save(movie));
    }

    @Override
    public Movie getMovieById(long id) {
        return movieRepository.getOne(id);
    }

    @Override
    public void deleteMovie(Movie movie) {
        movieRepository.delete(movie);
    }

    @Override
    public List<Movie> findAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public boolean isMovieExist(Movie movie) {
        return movieRepository.existsById(movie.getMovieId());
    }

    @Override
    public Optional<Movie> getMovieByTitle(String title) {
        return movieRepository.findByTitle(title);
    }
}
