package com.sparta.movieplanner.controllers.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@RequestMapping("/")

public class TelevisionController {
    Logger log = LoggerFactory.getLogger(TelevisionController.class);


    @GetMapping("television")
    public String searchTelevision() {
        String television = "television/searchTelevision";
        log.info("loading television search page: " + television + ".html");
        return television;
    }
}
