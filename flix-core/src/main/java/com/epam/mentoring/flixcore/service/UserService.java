package com.epam.mentoring.flixcore.service;

import com.epam.mentoring.flixcore.model.User;

import java.util.List;

public interface UserService {

    User findUserByEmail(String email);

    void saveUser(User user);

    User getUserById(long id);

    void deleteUser(User user);

    List<User> findAllUsers();

    boolean isUserExist(User user);
}
