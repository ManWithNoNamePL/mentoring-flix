package com.epam.mentoring.flixcore.model;

import javax.persistence.*;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    protected Integer id;

    private  String title;

    private String genre;

    private int runtime;
}
