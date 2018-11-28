package com.epam.mentoring.flixcore.service.impl;

import com.epam.mentoring.flixcore.model.Role;
import com.epam.mentoring.flixcore.model.User;
import com.epam.mentoring.flixcore.model.UserRole;
import com.epam.mentoring.flixcore.repository.UserRepository;
import com.epam.mentoring.flixcore.repository.UserRoleRepository;
import com.epam.mentoring.flixcore.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private UserRoleRepository userRoleRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void saveUser(User user) {
        System.out.println("1user = " + user);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        UserRole userRole = userRoleRepository.findByRole(Role.ADMIN);
        user.setUserRoles(new HashSet<>(Arrays.asList(userRole)));
        System.out.println("2user = " + user);
        userRepository.save(user);
    }


    @Override
    public User getUserById(long id) {
        return userRepository.getOne(id);
    }

    @Override
    public void deleteUser(User user){
        userRepository.delete(user);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public boolean isUserExist(User user) {
        return userRepository.existsById(user.getUserId());
    }

}
