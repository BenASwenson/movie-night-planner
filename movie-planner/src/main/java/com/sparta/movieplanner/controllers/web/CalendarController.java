package com.sparta.movieplanner.controllers.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class CalendarController {

    Logger log = LoggerFactory.getLogger(CalendarController.class);

    @GetMapping("calendar")
    public String calendar() {
        String calendar = "calendar/calendar";
        log.info("loading calendar page: " + calendar + ".html");
        return calendar;
    }



}
