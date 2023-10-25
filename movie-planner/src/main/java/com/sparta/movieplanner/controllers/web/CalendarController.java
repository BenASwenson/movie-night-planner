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
public class CalendarController {

    Logger log = LoggerFactory.getLogger(CalendarController.class);

    @GetMapping("calendar")
    public String calendar(@RequestParam(name="logout", required = false) String logout, Authentication authentication, Model model) {
        model.addAttribute("activePage", "calendar");
        String activePage = (String) model.getAttribute("activePage");
        String calendar = "calendar/calendar";
        log.info("Active Page: " + activePage);
        log.info("loading calendar page: " + calendar + ".html");

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

        return calendar;
    }



}
