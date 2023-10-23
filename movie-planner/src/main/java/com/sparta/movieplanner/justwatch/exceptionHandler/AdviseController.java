package com.sparta.movieplanner.justwatch.exceptionHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.io.FileNotFoundException;
import java.util.MissingResourceException;

@RestControllerAdvice
@Order(value = Ordered.HIGHEST_PRECEDENCE)
public class AdviseController {
    Logger log = LoggerFactory.getLogger(getClass());

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNotHandledException(NoHandlerFoundException e) {
        //log.error(e.getMessage());
        return "<h1>Looks like something went wrong...</h1>";
    }
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoHandlerFoundException.class)
    public String handleNoHandlerFoundException(NoHandlerFoundException ex) {
        log.error("404 situation detected.",ex);
        return "Specified path not found on this server";
    }
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleIllegalArgumentException(IllegalArgumentException e) {
        log.error("The object doesn't exist 404 Not Found",e);
        return "<h1>The Movie/Show you are looking for does not exist...</h1>";
    }
    @ExceptionHandler(MissingResourceException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handlelMissingResourceException(MissingResourceException e) {
        log.error("The object doesn't exist 404 Not Found",e);
        return "<h1>The Movie/Show you are looking for does not have providers...</h1>";
    }
    @ExceptionHandler(FileNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleFileNotFoundException(FileNotFoundException e) {
        log.error(e.getMessage());
        return "<h1>File not found...<h1>";
    }

    @ExceptionHandler(ResourceAccessException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleResourceNotFoundException(ResourceAccessException e) {
        log.error(e.getMessage());
        return "<h1>Missing resource...</h1>";
    }
    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNullPointerException(NullPointerException e) {
        log.error(e.getMessage());
        return "<h1>Looks like it's missing...</h1>";
    }

    @ExceptionHandler(HttpServerErrorException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleHttpServerErrorException(HttpServerErrorException e) {
        log.error(e.getMessage());
        return "<h1>Server error...</h1>";
    }
}
