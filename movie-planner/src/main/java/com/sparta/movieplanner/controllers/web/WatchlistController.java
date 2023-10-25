package com.sparta.movieplanner.controllers.web;

import com.sparta.movieplanner.entities.Type;
import com.sparta.movieplanner.entities.User;
import com.sparta.movieplanner.entities.Watchlist;
import com.sparta.movieplanner.repositories.UserRepository;
import com.sparta.movieplanner.repositories.WatchlistRepository;
import com.sparta.movieplanner.services.WatchlistService;
import com.sparta.movieplanner.tmdb.MediaShort;
import com.sparta.movieplanner.tmdb.MovieDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/")
public class WatchlistController {
    Logger log = LoggerFactory.getLogger(WatchlistController.class);
    private final String watchlistHtmlPagePath = "watchList/watchList";
    private final String movieHtmlPagePath = "movie/searchMovie";
    @Autowired
    WatchlistService watchlistService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private WatchlistRepository watchlistRepository;


    @GetMapping("watchList")
    public String watchList(Authentication authentication, Model model) {
        model.addAttribute("activePage", "watchList");
        String activePage = (String) model.getAttribute("activePage");
        log.info("Active Page: " + activePage);
        log.info("loading watchlist page: " + watchlistHtmlPagePath + ".html");

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

        return watchlistHtmlPagePath;
    }

    @Transactional
    @PostMapping("addToWatchlist/movies")
    public String addToWatchlist(@RequestParam("movieTitle") String movieTitle, @RequestParam("movieId") int movieId, Authentication authentication, Model model){
        log.info("addToWatchlist method active");

        String username = authentication.getName();

        log.info("New movie watchlist entry for: {} is being created", movieTitle);
        Watchlist newWatchlistEntry = watchlistService.createMovieWatchlistEntry(movieTitle, movieId, username);

        Watchlist savedEntry = watchlistRepository.saveAndFlush(newWatchlistEntry);
        log.info("New movie watchlist entry saved, {}", savedEntry);

        if (watchlistRepository.findById(savedEntry.getId()).isPresent()) {
            model.addAttribute("addedToWatchlist", "Added To Watchlist");
        }

//        return "redirect:/movies";
        return watchlistHtmlPagePath;
    }



}
