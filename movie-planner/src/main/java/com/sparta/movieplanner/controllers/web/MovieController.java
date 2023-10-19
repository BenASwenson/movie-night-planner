package com.sparta.movieplanner.controllers.web;

import com.sparta.movieplanner.dto.MovieDTO;
import com.sparta.movieplanner.services.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/")
public class MovieController {

    Logger log = LoggerFactory.getLogger(MovieController.class);
    private final MovieService movieService;
    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("movies")
    public String movieSearch(@RequestParam(name = "query", required = false)String query, Model model) {
        String movieSearch = "movie/searchMovie.html";
        if (query != null) {
            List<MovieDTO> movieDTOS = movieService.findMoviesByQuery(query);
            model.addAttribute("movies", movieDTOS);
        }
        log.info("loading homepage: " + movieSearch);
        return movieSearch;
    }
}
