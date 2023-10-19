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

import java.util.List;

@Controller
@RequestMapping("/")
public class MovieController {
    Logger log = LoggerFactory.getLogger(MovieController.class);
    private final String movieHtmlPagePath = "movie/searchMovie";
    @Autowired
    MovieService movieService;

    @GetMapping("movies")
    public String movies(Model model) {
        log.info("loading movies page: " + movieHtmlPagePath + ".html");



        return movieHtmlPagePath;
    }

    // TODO: add or change the above to receive the request for a movie given a query

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
