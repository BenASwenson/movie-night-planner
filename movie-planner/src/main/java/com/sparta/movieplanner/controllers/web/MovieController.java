package com.sparta.movieplanner.controllers.web;

import com.sparta.movieplanner.dto.MovieDTO;
import com.sparta.movieplanner.services.MovieService;
import com.sparta.movieplanner.tmdb.MovieShort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

@Controller
@RequestMapping("/")
public class MovieController {
    Logger log = LoggerFactory.getLogger(MovieController.class);
    private final String movieHtmlPagePath = "movie/searchMovie";
    private final MovieService movieService;
    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("movies")
    public String movieSearch(@RequestParam(name = "query", required = false)String query, Model model) {
            log.info("loading movies page: " + movieHtmlPagePath + ".html");
            if (query != null) {
                List<MovieDTO> movieDTOS = movieService.findMoviesByQuery(query);
                model.addAttribute("movies", movieDTOS);
            }
            return "movie/searchMovie";
    }

    @PostMapping("movies/search")
    public String searchMovies(@ModelAttribute("movieTitle") String title, Model model) {
        log.info("movie search bar active");
        log.info("move title from search bar: " + title);

        List<MovieShort> moviesList = movieService.findMoviesByTitle(title);

        if (!moviesList.isEmpty()) {
            model.addAttribute("results_populated", true);
            model.addAttribute("results_not_found", false);

            model.addAttribute("moviesList", moviesList);
        } else {
            model.addAttribute("results_populated", false);
            model.addAttribute("results_not_found", true);
        }

        return movieHtmlPagePath;
    }

}