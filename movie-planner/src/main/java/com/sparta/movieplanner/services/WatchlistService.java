package com.sparta.movieplanner.services;

import com.sparta.movieplanner.entities.Type;
import com.sparta.movieplanner.entities.Watchlist;
import com.sparta.movieplanner.repositories.UserRepository;
import com.sparta.movieplanner.repositories.WatchlistRepository;
import com.sparta.movieplanner.tmdb.MediaShort;
import com.sparta.movieplanner.tmdb.MovieDetail;
import com.sparta.movieplanner.tmdb.Tmdb;
import com.sparta.movieplanner.tmdb.TvSeries;
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

    public List<MovieDetail> getMovieWatchlistByUserId(Long userId) {
        log.info("get movie watchlist by user id method is active");
        List<Watchlist> userMovieWatchlist = findAllEntries_ByUserIdAndMediaType(userId, Type.FILM);

        List<MovieDetail> movieList = new ArrayList<>();

        for (Watchlist watchlist : userMovieWatchlist) {
            int movieId = watchlist.getTitleId();
            MovieDetail movieDetail = tmdb.getMovieDetail(movieId);

            movieList.add(movieDetail);
        }

        return movieList;
    }

    public List<TvSeries> getTvShowWatchlistByUserId(Long userId) {
        log.info("get tv show watchlist by user id method is active");
        List<Watchlist> userTvShowWatchlist = findAllEntries_ByUserIdAndMediaType(userId, Type.TV_SHOW);

        List<TvSeries> tvShowList = new ArrayList<>();

        for (Watchlist watchlist : userTvShowWatchlist) {
            log.info("inside tv for loop");
            int tvShowId = watchlist.getTitleId();
            log.info("getting tv series by id");
            TvSeries tvSeries = tmdb.getTvSeries(tvShowId);
            log.info("retrieved tv series {}", tvSeries);
            tvShowList.add(tvSeries);
        }


        return tvShowList;
    }

    public List<MediaShort> getAllWatchlistByUserId(Long userId) {
        log.info("get all watchlist by user id method active");
        List<Watchlist> getAllWatchlist = findAllEntries_ByUserId(userId);

        List<MediaShort> allWatchlistList = new ArrayList<>();

        for (Watchlist watchlist : getAllWatchlist) {
            log.info("inside all for loop");
            int id = watchlist.getTitleId();
            if (watchlist.getType().equals(Type.FILM)) {
                log.info("getting movie by id");
                MovieDetail movieDetail = tmdb.getMovieDetail(id);
                log.info("retrieved movie {}", movieDetail);

                // TODO: simplify this into a converter
                MediaShort mediaShort = new MediaShort();
                mediaShort.setId(id);
                mediaShort.setTitle(movieDetail.getTitle());
                mediaShort.setOverview(movieDetail.getOverview());
                mediaShort.setPopularity(movieDetail.getPopularity());
                mediaShort.setRelease_date(movieDetail.getRelease_date());
                mediaShort.setVote_average(movieDetail.getVote_average());
                mediaShort.setVote_count((int) movieDetail.getVote_count());
                mediaShort.setPoster_path(movieDetail.getPoster_path());

                log.info("movie mediaShort: {}", mediaShort);
                allWatchlistList.add(mediaShort);

            } else if (watchlist.getType().equals(Type.TV_SHOW)) {
                log.info("getting tv series by id");
                TvSeries tvSeries = tmdb.getTvSeries(id);
                log.info("retrieved tv series {}", tvSeries);

                // TODO: simplify this into a converter
                MediaShort mediaShort = new MediaShort();
                mediaShort.setId(id);
                mediaShort.setTitle(tvSeries.getName());
                mediaShort.setOverview(tvSeries.getOverview());
                mediaShort.setPopularity(tvSeries.getPopularity());
                mediaShort.setRelease_date(tvSeries.getFirst_air_date());
                mediaShort.setVote_average(tvSeries.getVote_average());
                mediaShort.setVote_count(tvSeries.getVote_count());
                mediaShort.setPoster_path(tvSeries.getPoster_path());

                log.info("tv show mediaShort: {}", mediaShort);
                allWatchlistList.add(mediaShort);
            }
        }

        return allWatchlistList;

    }
    public List<Watchlist> findAllEntries_ByUserId(Long userId) {
        log.info("find all entries by user id method active");
        List<Watchlist> userWatchlist = watchlistRepository.findAllByUserId(userId);
        log.info("retrieved a list of entries from database: {}", userWatchlist);

        return userWatchlist;
    }

    public List<Watchlist> findAllEntries_ByUserIdAndMediaType(Long userId, Type mediaType) {
        log.info("find all entries by user is and media type method active");
        List<Watchlist> userWatchlist = watchlistRepository.findAllByUser_IdAndType(userId, mediaType);
        log.info("retrieved a list of {} entries from database: {}",mediaType, userWatchlist);

        return userWatchlist;
    }


}
