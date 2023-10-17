package com.sparta.movieplanner.controllers.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiControllerTest {
    Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping("api/v1/test")
    public String test() {
        log.info("Test controller is active");
        return "This is a test for API endpoint.";
    }
}
