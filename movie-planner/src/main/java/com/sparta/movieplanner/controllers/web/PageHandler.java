package com.sparta.movieplanner.controllers.web;

import com.sparta.movieplanner.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PageHandler {
    Logger log = LoggerFactory.getLogger(PageHandler.class);

    @Autowired
    MovieService movieService;

    @GetMapping("login")
    public String loginPage() {
        String login = "login/login";
        log.info("loading login page: " + login + ".html");

        return login;
    }

    @GetMapping("movies")
    public String homepage() {
        String movies = "movie/searchMovie";
        log.info("loading homepage: " + movies + ".html");

        return movies;
    }

    // TODO: add or change the above to receive the request for a movie given a query

    @GetMapping("register")
    public String signUp() {
        String registerPage = "user/createUser";
        log.info("loading register page: " + registerPage + ".html");

        return registerPage;
    }

    @GetMapping("television")
    public String searchTelevision() {
        String television = "television/searchTelevision";
        log.info("loading television search page: " + television + ".html");
        return television;
    }

    @GetMapping("genres")
    public String searchGenres() {
        String genres = "genres/searchGenres";
        log.info("loading television search page: " + genres + ".html");
        return genres;
    }

    @GetMapping("watchList")
    public String watchList() {
        String watchList = "watchList/watchList";
        log.info("loading watch list page: " + watchList + ".html");
        return watchList;
    }

    @GetMapping("calendar")
    public String calendar() {
        String calendar = "calendar/calendar";
        log.info("loading calendar page: " + calendar + ".html");
        return calendar;
    }



}
