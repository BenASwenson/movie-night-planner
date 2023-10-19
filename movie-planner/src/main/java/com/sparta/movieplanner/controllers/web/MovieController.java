package com.sparta.movieplanner.controllers.web;

import com.sparta.movieplanner.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MovieController {

    Logger log = LoggerFactory.getLogger(MovieController.class);

    @Autowired
    MovieService movieService;

    // TODO: add or change the above to receive the request for a movie given a query
    @GetMapping("movies")
    public String homepage() {
        String movies = "movie/searchMovie";
        log.info("loading homepage: " + movies + ".html");

        return movies;
    }
}
