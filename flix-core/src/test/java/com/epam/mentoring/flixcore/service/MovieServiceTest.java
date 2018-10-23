package com.epam.mentoring.flixcore.service;

import com.epam.mentoring.flixcore.FlixCoreApplication;
import com.epam.mentoring.flixcore.model.Genre;
import com.epam.mentoring.flixcore.model.Movie;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FlixCoreApplication.class)
public class MovieServiceTest {

    @Autowired
    private MovieService movieService;

    private Movie lordOfTheRings;
    private Movie titanic;

    @Before
    public void initMovies() throws Exception {
        lordOfTheRings = new Movie("Lord of the Rings", Genre.FANTASY, 146);
        titanic = new Movie("Titanic", Genre.DRAMA, 152);
    }

    @After
    public void deleteMovies() throws Exception {
        movieService.deleteMovie(lordOfTheRings);
        movieService.deleteMovie(titanic);
    }

    @Test
    public void shouldReturnMovieByTitle() {
        movieService.createMovie(lordOfTheRings);

        Optional<Movie> found = movieService.getMovieByTitle(lordOfTheRings.getTitle());

        assertThat(found.get()).isEqualTo(lordOfTheRings);
    }

    @Test
    public void shouldCreateMovies() {
        movieService.createMovie(lordOfTheRings);
        movieService.createMovie(titanic);

        List<Movie> allMovies = movieService.findAllMovies();

        assertThat(allMovies)
                .isNotNull()
                .isNotEmpty()
                .containsAnyOf(titanic);
    }

    @Test
    public void shouldDeleteMovie() {
        movieService.createMovie(lordOfTheRings);
        movieService.createMovie(titanic);

        movieService.deleteMovie(lordOfTheRings);
        List<Movie> allMovies = movieService.findAllMovies();

        assertThat(allMovies)
                .hasSize(1)
                .doesNotContain(lordOfTheRings);
    }

    @Test
    public void shouldReturnTrueIfMovieExist() {
        movieService.createMovie(titanic);

        boolean movieExist = movieService.isMovieExist(titanic);

        assertThat(movieExist)
                .isTrue();
    }
}