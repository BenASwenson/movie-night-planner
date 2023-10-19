package com.sparta.movieplanner.services;

import com.sparta.movieplanner.dto.UserDTO;
import com.sparta.movieplanner.entities.Role;
import com.sparta.movieplanner.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private PasswordEncoder encoder;

    public User createNewUser(UserDTO userDetails) {
        log.info("In the register service");

        User newUser = new User();
        newUser.setId(0L);
        newUser.setFirstName(validateFirstName(userDetails));
        newUser.setLastName(validateLastName(userDetails));
        newUser.setUsername(validateUsername(userDetails));
        newUser.setPassword(encoder.encode(validatePassword(userDetails)));
        newUser.setRole(Role.USER);

        return newUser;
    }

    private String validateFirstName(UserDTO userDetails) throws NullPointerException {
        if (userDetails.getFirstName() == null || userDetails.getFirstName().isBlank() || userDetails.getFirstName().isEmpty())
            throw new NullPointerException("Error: First name field is null or blank");
        log.info("validate first name");

        String firstName = formatName(userDetails.getFirstName());

        // TODO: validate name with regex (no numbers)

        return firstName;
    }

    private String validateLastName(UserDTO userDetails) throws NullPointerException {
        if (userDetails.getLastName() == null || userDetails.getLastName().isBlank() || userDetails.getLastName().isEmpty())
            throw new NullPointerException("Error: Last name field is null or blank");

        log.info("validate last name");

        String lastName = formatName(userDetails.getLastName());

        // TODO: validate name with regex (no numbers)

        return lastName;
    }

    private String validateUsername(UserDTO userDetails) throws NullPointerException {
        if (userDetails.getUsername() == null || userDetails.getUsername().isBlank() || userDetails.getUsername().isEmpty())
            throw new NullPointerException("Error: Username field is null or blank");

        log.info("validate username");

        String username = formatUsername(userDetails.getUsername());

        // TODO: validate username with regex

        return username;
    }

    private CharSequence validatePassword(UserDTO userDetails) throws NullPointerException {
        if (userDetails.getPassword() == null || userDetails.getPassword().isBlank() || userDetails.getPassword().isEmpty())
            throw new NullPointerException("Error: Password field is null or blank");

        log.info("validate password");

        String password = formatPassword(userDetails.getPassword());

        // TODO: validate password with regex (at least 1 uppercase, 1 lowercase, 1 number, min 8 characters long)

        return password;
    }

    private String formatName(String name) {
        log.info("formatting name");

        String formatName = name.trim();
        String initialCapitalLetter = formatName.substring(0, 1).toUpperCase();
        String restOfName = formatName.substring(1).toLowerCase();

        return initialCapitalLetter + restOfName;
    }

    private String formatUsername(String username) {
        log.info("formatting username");
        return username.trim().toLowerCase();
    }

    private String formatPassword(String password) {
        log.info("formatting password");
        return password.trim();
    }


}
