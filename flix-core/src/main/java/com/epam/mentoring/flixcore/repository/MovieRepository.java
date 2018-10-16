package com.epam.mentoring.flixcore.repository;

import com.epam.mentoring.flixcore.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
