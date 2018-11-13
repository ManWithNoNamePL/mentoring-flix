package com.epam.mentoring.flixcore.model;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "user_role")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private int id;

    @Enumerated(EnumType.STRING)
    private Role role;
}
