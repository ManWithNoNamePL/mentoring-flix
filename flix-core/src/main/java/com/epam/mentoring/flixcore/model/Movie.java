package com.epam.mentoring.flixcore.model;

import javax.persistence.*;

@Entity
public class Movie {

    public Movie() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MOVIE_ID")
    private long movieId;

    private  String title;

    private Genre genre;

    private int runtime;

    public Movie(String title, Genre genre, int runtime) {
        this.title = title;
        this.genre = genre;
        this.runtime = runtime;
    }

    public Movie(long id, String title, Genre genre, int runtime) {
        this.movieId = id;
        this.title = title;
        this.genre = genre;
        this.runtime = runtime;
    }

    public long getMovieId() {
        return movieId;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", title='" + title + '\'' +
                ", genre=" + genre +
                ", runtime=" + runtime +
                '}';
    }
}
