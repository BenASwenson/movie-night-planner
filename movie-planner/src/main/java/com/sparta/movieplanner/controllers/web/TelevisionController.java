package com.sparta.movieplanner.controllers.web;

import com.sparta.movieplanner.services.TelevisionService;
import com.sparta.movieplanner.tmdb.MediaShort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Controller
@RequestMapping("/")

public class TelevisionController {
    Logger log = LoggerFactory.getLogger(TelevisionController.class);

    private final String televisionHtmlPagePath = "television/searchTelevision";

    private final TelevisionService televisionService;

    @Autowired
    public TelevisionController(TelevisionService televisionService) {
        this.televisionService = televisionService;
    }


    @GetMapping("television")
    public String searchTelevision(@RequestParam(name="logout", required = false) String logout, Authentication authentication, Model model) {
        model.addAttribute("activePage", "television");
        String activePage = (String) model.getAttribute("activePage");
        log.info("Active Page: " + activePage);
        log.info("loading television search page: " + televisionHtmlPagePath + ".html");


        /**
         * Authentication section is being used to control navigation view to
         * the watchlist and calendar tabs
         */

        if (authentication != null) {
            log.info("user is authenticated");
            model.addAttribute("authenticated", true);
        } else {
            log.info("user is not authenticated or not logged in");
            model.addAttribute("authenticated", false);
        }

        return televisionHtmlPagePath;
    }

    @PostMapping("television/search")
    public String searchTelevision(@ModelAttribute("televisionTitle") String title, Model model) {
        log.info("television search bar active");
        log.info("television title from search bar: " + title);

        List<MediaShort> televisionList = televisionService.findTelevisionByTitle(title);

        if (!televisionList.isEmpty()) {
            model.addAttribute("results_populated", true);
            model.addAttribute("results_not_found", false);
            model.addAttribute("televisionList", televisionList);
        } else {
            model.addAttribute("results_populated", false);
            model.addAttribute("results_not_found", true);
        }
        return televisionHtmlPagePath;
    }
}
