package com.sparta.movieplanner.controllers.web;

import com.sparta.movieplanner.entities.User;
import com.sparta.movieplanner.entities.Watchlist;
import com.sparta.movieplanner.repositories.UserRepository;
import com.sparta.movieplanner.repositories.WatchlistRepository;
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
    private WatchlistRepository watchlistRepository;
    @Autowired
    private UserRepository userRepository;


    @GetMapping("watchList")
    public String watchList(Authentication authentication, Model model) {
        model.addAttribute("activePage", "watchList");
        String activePage = (String) model.getAttribute("activePage");
        log.info("Active Page: " + activePage);
        log.info("loading watchlist page: " + watchlistHtmlPagePath + ".html");

        if (authentication != null) {
            log.info("user is authenticated");
            model.addAttribute("authenticated", true);
        } else {
            log.info("user is not authenticated or not logged in");
            model.addAttribute("authenticated", false);
        }

        User user = userRepository.findByUsername(authentication.getName()).get();

        List<Watchlist> watchlist = watchlistRepository.findAllByUserId(user.getId());

        if (!watchlist.isEmpty()) {
            // TODO: implement a for loop that goes through movies similar to movie controller
            // TODO: implement a watchlist service
            model.addAttribute("watchlist", watchlist);
            model.addAttribute("watchlist_populated", true);
        } else {
            model.addAttribute("watchlist_populated", false);
        }

        return watchlistHtmlPagePath;
    }

    @Transactional
    @PostMapping("addToWatchlist")
    public String addToWatchlist(@RequestParam("movieTitle") String movieTitle, Authentication authentication, Model model){
        log.info("addToWatchlist method active");

        log.info("New watch list entry for: {} is being created", movieTitle);
        Watchlist newWatchlistEntry = new Watchlist();
        newWatchlistEntry.setId(0L);
        newWatchlistEntry.setUser(userRepository.findByUsername(authentication.getName()).get());
        newWatchlistEntry.setMovieTitle(movieTitle);

        Watchlist savedEntry = watchlistRepository.saveAndFlush(newWatchlistEntry);
        log.info("New watch list entry saved, {}", savedEntry);

        if (watchlistRepository.findById(savedEntry.getId()).isPresent()) {
            model.addAttribute("addedToWatchlist", "Added To Watchlist");
        }

//        return "redirect:/movies";
        return watchlistHtmlPagePath;
    }

}
