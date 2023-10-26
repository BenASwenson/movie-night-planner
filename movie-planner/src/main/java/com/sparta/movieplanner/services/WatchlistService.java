package com.sparta.movieplanner.services;

import com.sparta.movieplanner.entities.Type;
import com.sparta.movieplanner.entities.Watchlist;
import com.sparta.movieplanner.repositories.UserRepository;
import com.sparta.movieplanner.repositories.WatchlistRepository;
import com.sparta.movieplanner.tmdb.MediaShort;
import com.sparta.movieplanner.tmdb.MovieDetail;
import com.sparta.movieplanner.tmdb.Tmdb;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WatchlistService {
    Logger log = LoggerFactory.getLogger(getClass());
    @Autowired
    private Tmdb tmdb;
    @Autowired
    private MovieService movieService;
    @Autowired
    private WatchlistRepository watchlistRepository;
    @Autowired
    private UserRepository userRepository;

    public Watchlist createMovieWatchlistEntry(String movieTitle, int movieId, String username ) {
        log.info("create movie watchlist entry method active");
        Watchlist newWatchlistEntry = new Watchlist();
        newWatchlistEntry.setId(0L);
        newWatchlistEntry.setUser(userRepository.findByUsername(username).get());
        newWatchlistEntry.setTitleId(movieId);
        newWatchlistEntry.setTitle(movieTitle);
        newWatchlistEntry.setType(Type.FILM);
        return newWatchlistEntry;
    }

    public List<MovieDetail> getMovieWatchlistByUserId(Long userId) {
        List<Watchlist> userMovieWatchlist = findAllEntries_ByUserId(userId);
        List<MovieDetail> movieList = new ArrayList<>();

        for (Watchlist watchlist : userMovieWatchlist) {
            int movieId = watchlist.getTitleId();
            MovieDetail movieDetail = tmdb.getMovieDetail(movieId);


            movieList.add(movieDetail);
        }

        return movieList;
    }

    public Watchlist createTvShowWatchlistEntry(String tvShowTitle, int tvShowId, String username ) {
        log.info("create tv show watchlist entry method active");
        Watchlist newWatchlistEntry = new Watchlist();
        newWatchlistEntry.setId(0L);
        newWatchlistEntry.setUser(userRepository.findByUsername(username).get());
        newWatchlistEntry.setTitleId(tvShowId);
        newWatchlistEntry.setTitle(tvShowTitle);
        newWatchlistEntry.setType(Type.TV_SHOW);
        return newWatchlistEntry;
    }

    public List<Watchlist> findAllEntries_ByUserId(Long userId) {
        List<Watchlist> userWatchlist = watchlistRepository.findAllEntries_ByUserId(userId);

        return userWatchlist;
    }


}
