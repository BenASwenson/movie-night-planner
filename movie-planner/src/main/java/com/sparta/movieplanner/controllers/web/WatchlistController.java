package com.sparta.movieplanner.controllers.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class WatchlistController {

    Logger log = LoggerFactory.getLogger(WatchlistController.class);

    @GetMapping("watchList")
    public String watchList() {
        String watchList = "watchList/watchList";
        log.info("loading watch list page: " + watchList + ".html");
        return watchList;
    }

}
