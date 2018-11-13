package com.epam.mentoring.flixcore.repository;

import com.epam.mentoring.flixcore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByLogin(String login);
}
