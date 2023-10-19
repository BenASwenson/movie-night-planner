package com.sparta.movieplanner;

import com.sparta.movieplanner.entities.Role;
import com.sparta.movieplanner.entities.User;
import com.sparta.movieplanner.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest

public class UserTests {

    @Autowired
    UserRepository userRepository;

    @Test
    public void findUserInDatabase() {
        User expected = new User();
        expected.setId(1L);
        expected.setFirstName("Jade");
        expected.setLastName("Sale");
        expected.setUsername("jade@mail.com");
        expected.setPassword("pass");
        expected.setRole(Role.USER);

        User result = userRepository.findUserById(1L);

        assertEquals(expected.toString(), result.toString());
    }
}
