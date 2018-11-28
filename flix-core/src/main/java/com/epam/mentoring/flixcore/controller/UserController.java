package com.epam.mentoring.flixcore.controller;

import com.epam.mentoring.flixcore.model.User;
import com.epam.mentoring.flixcore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping
    public ResponseEntity<List<User>> listAllUsers() {
        List<User> users = userService.findAllUsers();
        if(users.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(users);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") long id) {
        User user = userService.getUserById(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
        if (userService.isUserExist(user)) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        userService.saveUser(user);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/{id}").buildAndExpand(user.getUserId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user) {
        User currentUser = userService.getUserById(id);

        if (currentUser==null) {
            return ResponseEntity.notFound().build();
        }

        updateEntity(user, currentUser);

        userService.saveUser(currentUser);
        return ResponseEntity.ok(currentUser);
    }

    private void updateEntity(@RequestBody User user, User currentUser) {
        currentUser.setEmail(user.getEmail());
        currentUser.setAge(user.getAge());
        currentUser.setPassword(user.getPassword());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable("id") long id) {
        User user = userService.getUserById(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        userService.deleteUser(user);
        return ResponseEntity.noContent().build();
    }
}
