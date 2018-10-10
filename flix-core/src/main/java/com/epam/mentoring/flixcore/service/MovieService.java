package com.epam.mentoring.flixcore.service;

import com.epam.mentoring.flixcore.model.Movie;

public interface MovieService {

    void createMovie(Movie movie);

    Movie getMovieById(Integer id);

    void deleteMovie(Movie movie);
}
