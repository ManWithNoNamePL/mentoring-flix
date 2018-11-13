package com.epam.mentoring.flixcore.model;

import lombok.Data;

import javax.persistence.*;

@Data
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
}
