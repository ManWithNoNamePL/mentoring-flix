package com.epam.mentoring.flixcore.service;

import com.epam.mentoring.flixcore.model.User;

public interface UserService {

    void createUser(User user);

    User getUserById(Integer id);

    void deleteUser(User user);
}
