package com.sparta.movieplanner.controllers.web;

import com.sparta.movieplanner.entities.User;
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
public class HomepageHandler {

    Logger log = LoggerFactory.getLogger(HomepageHandler.class);

    @GetMapping("homepage")
    public String homepage(@RequestParam(name = "logout", required = false) String logout, Model model, Authentication authentication) {
        String homepage = "movie/searchMovie";
        log.info("loading homepage: " + homepage + ".html");

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

        return homepage;
    }
}
