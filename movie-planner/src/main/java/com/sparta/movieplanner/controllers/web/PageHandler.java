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

    @GetMapping("homepage")
    public String homepage() {
        String homepage = "movie/searchMovie";
        log.info("loading homepage: " + homepage + ".html");

        return homepage;
    }
}
