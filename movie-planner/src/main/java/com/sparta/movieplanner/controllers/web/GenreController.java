package com.sparta.movieplanner.controllers.web;

import com.sparta.movieplanner.dto.GenreDTO;
import com.sparta.movieplanner.services.GenreService;
import com.sparta.movieplanner.tmdb.MediaShort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/")
public class GenreController {

    Logger log = LoggerFactory.getLogger(GenreController.class);

    private final String genreHtmlPagePath = "genres/searchGenres";

    @Autowired
    private GenreService genreService;

    @GetMapping("genres")
    public String searchGenres(@RequestParam(name="logout", required = false) String logout, Authentication authentication, Model model) {
        model.addAttribute("activePage", "genres");
        String activePage = (String) model.getAttribute("activePage");
        log.info("Active Page: " + activePage);
        log.info("loading genres search page: " + genreHtmlPagePath + ".html");

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
        return genreHtmlPagePath;
    }

    @PostMapping("genres/search")
    public String searchByGenre(@RequestParam("genreId") int genreId,  Model model) throws IOException, InterruptedException {

        log.info("genre id from button: " + genreId);

        List<MediaShort> moviesList = genreService.getMoviesByGenre(genreId);

        model.addAttribute("results_populated", !moviesList.isEmpty());
        model.addAttribute("results_not_found", moviesList.isEmpty());
        model.addAttribute("genresList", moviesList);

        return genreHtmlPagePath;
    }
}
