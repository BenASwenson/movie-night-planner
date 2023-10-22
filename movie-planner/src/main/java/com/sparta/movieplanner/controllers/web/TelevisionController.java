package com.sparta.movieplanner.controllers.web;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")

public class TelevisionController {
    Logger log = LoggerFactory.getLogger(TelevisionController.class);


    @GetMapping("television")
    public String searchTelevision(@RequestParam(name="logout", required = false) String logout, Authentication authentication, Model model) {
        model.addAttribute("activePage", "television");
        String activePage = (String) model.getAttribute("activePage");
        String searchTelevision = "television/searchTelevision";
        log.info("Active Page: " + activePage);
        log.info("loading television search page: " + searchTelevision + ".html");

        if (logout != null) {
            log.info("Logout was successful");
            model.addAttribute("logoutSuccess", true);
        }
        if (authentication != null) {
            log.info("user is authenticated");
            model.addAttribute("authenticated", true);
        } else {
            log.info("user is not authenticated or not logged in");
            model.addAttribute("authenticated", false);
        }

        return searchTelevision;
    }
}
