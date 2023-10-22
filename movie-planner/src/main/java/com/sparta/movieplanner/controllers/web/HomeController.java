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
public class HomeController {

    Logger log = LoggerFactory.getLogger(HomeController.class);

    @GetMapping("/home")
    public String homepage(@RequestParam(name = "logout", required = false) String logout, Model model, Authentication authentication) {
        String home = "home/home";
        model.addAttribute("activePage", "home");
        String activePage = (String) model.getAttribute("activePage");
        log.info("Active Page: " + activePage);
        log.info("loading homepage: " + home + ".html");

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

        return home;
    }
}
