package com.epam.mentoring.flixcore.service.impl;

import com.epam.mentoring.flixcore.model.Movie;
import com.epam.mentoring.flixcore.repository.MovieRepository;
import com.epam.mentoring.flixcore.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public void createMovie(Movie movie) {
        movieRepository.save(movie);
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
}
