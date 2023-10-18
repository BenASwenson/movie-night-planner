package com.sparta.movieplanner.controllers.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PageHandler {
    Logger log = LoggerFactory.getLogger(PageHandler.class);

    @GetMapping("login")
    public String loginPage() {
        String loginPage = "login/login";
        log.info("loading login page: " + loginPage + ".html");

        return loginPage;
    }

    @GetMapping("homepage")
    public String homepage() {
        String homepage = "movie/searchMovie";
        log.info("loading homepage: " + homepage + ".html");

        return homepage;
    }

    @GetMapping("register")
    public String signUp() {
        String registerPage = "user/createUser";
        log.info("loading register page: " + registerPage + ".html");

        return registerPage;
    }
}
