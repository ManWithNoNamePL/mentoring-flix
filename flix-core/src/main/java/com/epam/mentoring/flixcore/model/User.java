package com.epam.mentoring.flixcore.model;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    protected Integer id;

    private String login;

    private String password;

    private int age;

    private String gender;
}
