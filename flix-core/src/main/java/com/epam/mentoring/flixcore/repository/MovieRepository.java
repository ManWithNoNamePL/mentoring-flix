package com.epam.mentoring.flixcore.repository;

import com.epam.mentoring.flixcore.model.Movie;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    Optional<Movie> findByTitle(String title);

    @Query(value = "select m from Movie m " +
            "left join fetch m.users u  " +
            "where u.userId = :userId " +
            "order by m.title")
    List<Movie> getViewedMoviesForUser(@Param("userId") long userId, Pageable pageable);

}
