package com.epam.mentoring.flixcore.service;

import com.epam.mentoring.flixcore.FlixCoreApplication;
import com.epam.mentoring.flixcore.model.Gender;
import com.epam.mentoring.flixcore.model.Role;
import com.epam.mentoring.flixcore.model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FlixCoreApplication.class)
public class UserServiceTest {

    private static final String LOGIN = "Edel123";

    @Autowired
    private UserService userService;

    private User user;

    @Before
    public void setUp() {
        user = new User();
        user.setUserId(1);
        user.setLogin(LOGIN);
        user.setAge(30);
        user.setGender(Gender.MALE);
        userService.createUser(user, Role.ADMIN);
    }

    @Test
    public void testFindUserByLogin() {
        // Setup
        final String login = LOGIN;

        // Run the test
        final User result = userService.getUserByLogin(login);

        // Verify the results
        assertEquals(login, result.getLogin());
    }

}
