package com.epam.mentoring.flixcore.service;

import com.epam.mentoring.flixcore.FlixCoreApplication;
import com.epam.mentoring.flixcore.model.Gender;
import com.epam.mentoring.flixcore.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FlixCoreApplication.class)
public class UserServiceTest {

    private static final String MAIL = "edel_123@mail.ru";
    private static final String PASSWORD = "123";

    @Autowired
    private UserService userService;

    private User user;

    @Before
    public void setUp() {
        user = new User();
        user.setUserId(1);
        user.setEmail(MAIL);
        user.setPassword(PASSWORD);
        user.setAge(30);
        user.setGender(Gender.MALE);
        userService.saveUser(user);
    }

    @Test
    public void testFindUserByLogin() {
        // Setup
        final String mail = MAIL;
        final String password = PASSWORD;

        // Run the test
        final User result = userService.findUserByEmail(mail);

        // Verify the results
        Assert.assertEquals(mail, result.getEmail());
    }

}
