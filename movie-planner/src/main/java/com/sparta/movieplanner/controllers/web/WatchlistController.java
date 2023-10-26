package com.sparta.movieplanner.controllers.web;

import com.sparta.movieplanner.entities.Type;
import com.sparta.movieplanner.entities.User;
import com.sparta.movieplanner.entities.Watchlist;
import com.sparta.movieplanner.repositories.UserRepository;
import com.sparta.movieplanner.repositories.WatchlistRepository;
import com.sparta.movieplanner.services.WatchlistService;
import com.sparta.movieplanner.tmdb.MediaShort;
import com.sparta.movieplanner.tmdb.MovieDetail;
import com.sparta.movieplanner.tmdb.TvSeries;
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

        User user = userRepository.findByUsername(authentication.getName()).get();
        Long userId = user.getId();

        /**
         * Returning a watchlist of movies
         * useful for a movie only filter
         */
        List<MovieDetail> movieWatchlist = watchlistService.getMovieWatchlistByUserId(userId);

        if (!movieWatchlist.isEmpty()) {
            log.info("movieWatchlist: {}", movieWatchlist);
            model.addAttribute("movieWatchlist", movieWatchlist);
            model.addAttribute("movieWatchlist_populated", true);
        } else {
            log.info("movieWatchlist is empty {}", movieWatchlist);
            model.addAttribute("movieWatchlist_populated", false);
        }

        /**
         * Returning a watchlist of tv shows
         * useful for a tv show only filter
         */
        List<TvSeries> tvSeriesWatchlist = watchlistService.getTvShowWatchlistByUserId(userId);

        if (!tvSeriesWatchlist.isEmpty()) {
            log.info("tvSeriesWatchlist: {}", tvSeriesWatchlist);
            model.addAttribute("tvSeriesWatchlist", tvSeriesWatchlist);
            model.addAttribute("tvSeriesWatchlist_populated", true);
        } else {
            log.info("tvSeriesWatchlist is empty {}", tvSeriesWatchlist);
            model.addAttribute("tvSeriesWatchlist_populated", false);
        }

        /**
         * Returning a watchlist of all entries
         */
        List<MediaShort> allWatchList = watchlistService.getAllWatchlistByUserId(userId);

        if (!allWatchList.isEmpty()) {
            log.info("allWatchList: {}", allWatchList);
            model.addAttribute("allWatchList", allWatchList);
            model.addAttribute("allWatchList_populated", true);
        } else {
            log.info("allWatchList is empty {}", allWatchList);
            model.addAttribute("allWatchList_populated", false);
        }




        return watchlistHtmlPagePath;
    }

    @Transactional
    @PostMapping("addToWatchlist/movies")
    public String addMoviesToWatchlist(@RequestParam("movieTitle") String movieTitle, @RequestParam("movieId") int movieId, Authentication authentication, Model model){
        log.info("addToWatchlist movie method active");

        String username = authentication.getName();

        log.info("New movie watchlist entry for: {} is being created", movieTitle);
        Watchlist newWatchlistEntry = watchlistService.createMovieWatchlistEntry(movieTitle, movieId, username);

        Watchlist savedEntry = watchlistRepository.saveAndFlush(newWatchlistEntry);
        log.info("New movie watchlist entry saved, {}", savedEntry);

        if (watchlistRepository.findById(savedEntry.getId()).isPresent()) {
            model.addAttribute("addedToWatchlist", "Added To Watchlist");
        }

        return "redirect:/watchList";
    }

    @Transactional
    @PostMapping("addToWatchlist/shows")
    public String addShowsToWatchlist(@RequestParam("tvShowTitle") String tvShowTitle, @RequestParam("tvShowId") int tvShowId, Authentication authentication, Model model) {
        log.info("addToWatchlist tv shows method active");

        String username = authentication.getName();

        log.info("New tv show watchlist entry for: {} is being created", tvShowTitle);
        Watchlist newWatchlistEntry = watchlistService.createTvShowWatchlistEntry(tvShowTitle, tvShowId, username);

        Watchlist savedEntry = watchlistRepository.saveAndFlush(newWatchlistEntry);
        log.info("New tv show watchlist entry saved, {}", savedEntry);

        if (watchlistRepository.findById(savedEntry.getId()).isPresent()) {
            model.addAttribute("addedToWatchlist", "Added To Watchlist");
        }

        return "redirect:/watchList";
    }

    @Transactional
    @PostMapping("addToWatchlist")
    public String addToWatchlist(@RequestParam("title") String title, @RequestParam("id") int titleId, @RequestParam("mediaType") String mediaType, Authentication authentication, Model model) {
        log.info("addToWatchlist landing page method active");


        String username = authentication.getName();

        log.info("media type is: {}", mediaType);


        if (mediaType.equals("movie")) {
            log.info("New movie watchlist entry for: {} is being created", title);
            Watchlist newWatchlistEntry = watchlistService.createMovieWatchlistEntry(title, titleId, username);

            Watchlist savedEntry = watchlistRepository.saveAndFlush(newWatchlistEntry);
            log.info("New movie watchlist entry saved, {}", savedEntry);

            if (watchlistRepository.findById(savedEntry.getId()).isPresent()) {
                model.addAttribute("addedToWatchlist", "Added To Watchlist");
            }
        }

        if (mediaType.equals("tv")) {
            log.info("New tv show watchlist entry for: {} is being created", title);
            Watchlist newWatchlistEntry = watchlistService.createTvShowWatchlistEntry(title, titleId, username);

            Watchlist savedEntry = watchlistRepository.saveAndFlush(newWatchlistEntry);
            log.info("New tv show watchlist entry saved, {}", savedEntry);

            if (watchlistRepository.findById(savedEntry.getId()).isPresent()) {
                model.addAttribute("addedToWatchlist", "Added To Watchlist");
            }
        }

        return "redirect:/watchList";


    }



}
