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
    public void setUp() throws Exception {
        lordOfTheRings = new Movie("Lord of the Rings", Genre.FANTASY, 146);
        titanic = new Movie ( "Titanic", Genre.DRAMA, 152);
        movieService.createMovie(lordOfTheRings);
        movieService.createMovie(titanic);
    }

    @After
    public void tearDown() throws Exception {
        movieService.deleteMovie(lordOfTheRings);
        movieService.deleteMovie(titanic);
    }

    @Test
    public void shouldReturnMovieByTitle() {
        // when
        Optional<Movie> found = movieService.getMovieByTitle(lordOfTheRings.getTitle());

        // then
        assertThat(found.get().getTitle()).isEqualTo(lordOfTheRings.getTitle());
    }

    @Test
    public void shouldCreateMovies() {
        // when
        List<Movie> allMovies = movieService.findAllMovies();

        // then
        assertThat(allMovies)
                .isNotNull()
                .isNotEmpty();
    }

    @Test
    public void shouldDeleteMovie() {
        // when
        movieService.deleteMovie(lordOfTheRings);
        List<Movie> allMovies = movieService.findAllMovies();

        // then
        assertThat(allMovies)
                .hasSize(1)
                .doesNotContain(lordOfTheRings);
    }

    @Test
    public void shouldReturnTrueIfMovieExist() {
        // when
        boolean movieExist = movieService.isMovieExist(titanic);
        // then
        assertThat(movieExist)
                .isTrue();
    }
}