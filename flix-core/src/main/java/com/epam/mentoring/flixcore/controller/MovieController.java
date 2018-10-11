package com.epam.mentoring.flixcore.controller;

import com.epam.mentoring.flixcore.model.Movie;
import com.epam.mentoring.flixcore.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Controller
public class MovieController {

    private static final String MOVIE_PATH_ROOT = "/movie/";

    @Autowired
    private MovieService movieService;

    @RequestMapping(value = MOVIE_PATH_ROOT, method = RequestMethod.GET)
    public ResponseEntity<List<Movie>> listAllMovies() {
        List<Movie> movies = movieService.findAllMovies();
        if(movies.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @RequestMapping(value = MOVIE_PATH_ROOT + "{id}", method = RequestMethod.GET)
    public ResponseEntity<Movie> getMovie(@PathVariable("id") long id) {
        Movie movie = movieService.getMovieById(id);
        if (movie == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @RequestMapping(value = MOVIE_PATH_ROOT, method = RequestMethod.POST)
    public ResponseEntity<Void> createMovie(@RequestBody Movie movie, UriComponentsBuilder ucBuilder) {
        if (movieService.isMovieExist(movie)) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        movieService.createMovie(movie);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path(MOVIE_PATH_ROOT + "{id}").buildAndExpand(movie.getMovieId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = MOVIE_PATH_ROOT + "{id}", method = RequestMethod.PUT)
    public ResponseEntity<Movie> updateMovie(@PathVariable("id") long id, @RequestBody Movie movie) {
        Movie currentMovie = movieService.getMovieById(id);

        if (currentMovie==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        updateEntity(movie, currentMovie);

        movieService.createMovie(currentMovie);
        return new ResponseEntity<>(currentMovie, HttpStatus.OK);
    }

    private void updateEntity(@RequestBody Movie movie, Movie currentMovie) {
        currentMovie.setTitle(movie.getTitle());
        currentMovie.setRuntime(movie.getRuntime());
        currentMovie.setGenre(movie.getGenre());
    }

    @RequestMapping(value = MOVIE_PATH_ROOT + "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Movie> deleteMovie(@PathVariable("id") long id) {
        Movie movie = movieService.getMovieById(id);
        if (movie == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        movieService.deleteMovie(movie);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
