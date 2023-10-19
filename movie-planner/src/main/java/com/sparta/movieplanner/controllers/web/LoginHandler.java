package com.sparta.movieplanner.controllers.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class LoginHandler {
    Logger log = LoggerFactory.getLogger(LoginHandler.class);

    @GetMapping("login")
    public String loginPage(@RequestParam(name = "error", required = false) String error, Model model) {
        String loginPage = "login/login";
        log.info("loading login page: " + loginPage + ".html");

        if (error != null) {
            log.error("Log in unsuccessful: wrong username or password");
            model.addAttribute("loginError", true);
        }

        return loginPage;
    }

}
