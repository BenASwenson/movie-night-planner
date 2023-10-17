package com.sparta.movieplanner.controllers.web;

import com.sparta.movieplanner.DTOs.UserDTO;
import com.sparta.movieplanner.entities.User;
import com.sparta.movieplanner.repositories.UserRepository;
import com.sparta.movieplanner.services.RegisterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class register {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    UserRepository userRepository;

    @Autowired
    RegisterService registerService;

    private final String registerHtmlPagePath = "user/createUser";

    @GetMapping("/register")
    public String signUp(Model model) {
        log.info("loading register page: " + registerHtmlPagePath + ".html");

        initializePageModel(model);

        return registerHtmlPagePath;
    }

    @Transactional
    @PostMapping("/register/form")
    public String registerNewUser(@ModelAttribute("user") UserDTO userDetails, Model model) {
        Optional<User> userExists = userRepository.findByUsername(userDetails.getUsername());

        // for thymeleaf to show message if user already exists
        if (userExists.isPresent()) {
            model.addAttribute("doesUserAlreadyExist", true);
            model.addAttribute("userAlreadyExistsMsg", "Email is already registered: " + userExists.get().getUsername());
            log.warn("User already exists: " + userExists.get().getUsername());
            return registerHtmlPagePath;
        } else {
            model.addAttribute("doesUserAlreadyExist", false);
        }

        // is this being transferred in the parameters?
//        model.addAttribute("user", userDetails);

        log.info("user = first name: {}", userDetails.getFirstName());
        log.info("user = last name: {}", userDetails.getLastName());
        log.info("user = username: {}", userDetails.getUsername());

        log.info("New user is being created");
        User newUser = registerService.createNewUser(userDetails);

        User user = userRepository.saveAndFlush(newUser);
        log.info("New user saved, {}", user);

        Optional<User> doesUserExist = userRepository.findByUsername(user.getUsername());

        if (doesUserExist.isPresent()) {
            model.addAttribute("registerSuccessful", true);
        } else {
            model.addAttribute("registerUnsuccessful", false);
        }

        return registerHtmlPagePath;
    }

    private void initializePageModel(Model model) {
        UserDTO userDetails = new UserDTO();
        model.addAttribute("user", userDetails);
    }
}
