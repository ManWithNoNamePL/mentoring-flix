package com.epam.mentoring.flixcore.service;

import com.epam.mentoring.flixcore.model.Movie;

import java.util.List;

public interface MovieService {

    void createMovie(Movie movie);

    Movie getMovieById(long id);

    void deleteMovie(Movie movie);

    List<Movie> findAllMovies();

    boolean isMovieExist(Movie movie);
}
