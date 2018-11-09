package com.epam.mentoring.flixcore.service;

import com.epam.mentoring.flixcore.model.Role;
import com.epam.mentoring.flixcore.model.User;

import java.util.List;

public interface UserService {

    void createUser(User user, Role role);

    User getUserById(long id);

    void deleteUser(User user);

    List<User> findAllUsers();

    boolean isUserExist(User user);

    User getUserByLogin(String login);
}
