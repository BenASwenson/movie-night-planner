package com.sparta.movieplanner.controllers.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class GenreController {

    Logger log = LoggerFactory.getLogger(GenreController.class);

    @GetMapping("genres")
    public String searchGenres() {
        String genres = "genres/searchGenres";
        log.info("loading television search page: " + genres + ".html");
        return genres;
    }
}
