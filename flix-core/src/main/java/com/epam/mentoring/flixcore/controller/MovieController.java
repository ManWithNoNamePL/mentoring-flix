package com.epam.mentoring.flixcore.controller;

import com.epam.mentoring.flixcore.model.Movie;
import com.epam.mentoring.flixcore.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Controller
@RequestMapping("/movie")
public class MovieController {


    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> listAllMovies() {
        List<Movie> movies = movieService.findAllMovies();
        if(movies.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(movies);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable("id") long id) {
        Movie movie = movieService.getMovieById(id);
        if (movie == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(movie);
    }

    @PostMapping
    public ResponseEntity<Void> createMovie(@RequestBody Movie movie, UriComponentsBuilder ucBuilder) {
        if (movieService.isMovieExist(movie)) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        movieService.createMovie(movie);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/{id}").buildAndExpand(movie.getMovieId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable("id") long id, @RequestBody Movie movie) {
        Movie currentMovie = movieService.getMovieById(id);

        if (currentMovie==null) {
            return ResponseEntity.notFound().build();
        }

        updateEntity(movie, currentMovie);

        movieService.createMovie(currentMovie);
        return ResponseEntity.ok(movie);
    }

    private void updateEntity(@RequestBody Movie movie, Movie currentMovie) {
        currentMovie.setTitle(movie.getTitle());
        currentMovie.setRuntime(movie.getRuntime());
        currentMovie.setGenre(movie.getGenre());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Movie> deleteMovie(@PathVariable("id") long id) {
        Movie movie = movieService.getMovieById(id);
        if (movie == null) {
            return ResponseEntity.notFound().build();
        }

        movieService.deleteMovie(movie);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/viewed/{userId}")
    public ResponseEntity<List<Movie>> getViewedMoviesForUser(@PathVariable("userId") long userId, @RequestParam("moviesNumber") int movieNumber) {
        System.out.println("userId = " + userId);
        System.out.println("movieNumber = " + movieNumber);
        List<Movie> viewedMovies = movieService.getViewedMoviesForUser(userId, movieNumber);
        if(viewedMovies.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok(viewedMovies);
    }
}
