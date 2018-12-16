package com.epam.mentoring.flixcore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class Movie {

    public Movie() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "movie_id")
    private long movieId;

    private  String title;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    private int runtime;

    @ManyToMany(mappedBy="viewedMovies")
    @JsonIgnore
    private List<User> users;

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
