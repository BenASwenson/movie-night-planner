package com.sparta.movieplanner.controllers.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class GenreController {

    Logger log = LoggerFactory.getLogger(GenreController.class);

    @GetMapping("genres")
    public String searchGenres(@RequestParam(name="logout", required = false) String logout, Authentication authentication, Model model) {
        model.addAttribute("activePage", "genres");
        String activePage = (String) model.getAttribute("activePage");
        String searchGenres = "genres/searchGenres";
        log.info("Active Page: " + activePage);
        log.info("loading genres search page: " + searchGenres + ".html");

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
        return searchGenres;
    }
}
