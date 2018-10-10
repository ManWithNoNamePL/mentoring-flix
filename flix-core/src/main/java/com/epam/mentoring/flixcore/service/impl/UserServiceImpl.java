package com.epam.mentoring.flixcore.service.impl;

import com.epam.mentoring.flixcore.model.User;
import com.epam.mentoring.flixcore.repository.UserRepository;
import com.epam.mentoring.flixcore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.getOne(id);
    }

    @Override
    public void deleteUser(User user){
        userRepository.delete(user);
    }
}
