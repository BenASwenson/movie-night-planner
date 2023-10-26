package com.sparta.movieplanner.services;

import com.sparta.movieplanner.converters.MovieShortConverter;
import com.sparta.movieplanner.dto.MovieDTO;
import com.sparta.movieplanner.tmdb.MediaShort;
import com.sparta.movieplanner.tmdb.Tmdb;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
    Logger log = LoggerFactory.getLogger(getClass());
    private final Tmdb tmdb;

    @Autowired
    private com.sparta.movieplanner.justwatch.service.MovieService justWatchMovieService;

    public MovieService(Tmdb tmdb) {
        this.tmdb = tmdb;
    }
    public List<MovieDTO> findMoviesByQuery(String query) {
        log.info("findMoviesByQuery method is active");
        List<MediaShort> movies = tmdb.findMovies(query);
        log.info("returned list of type MovieShort");
        List<MovieDTO> movieDTOs = new ArrayList<>();
        for(MediaShort movie : movies) {
            movieDTOs.add(new MovieShortConverter().entityToDto(movie));
        }
        log.info("returned list of type MovieDTO");
        return movieDTOs;
    }

    public List<MediaShort> findMoviesByTitle(String title) throws IOException, InterruptedException {
        log.info("find movies by title method active");
        // TODO: Use Tmdb class to pull data from movie, credit, person and glue them together into a MovieDTO list.

        List<MediaShort> movieShortList = tmdb.findMovies(title);

        for(int i = 0; i < movieShortList.size(); i++){
            int tmdbId = movieShortList.get(i).getId();
            movieShortList.get(i).setProviders(justWatchMovieService.findAllProvidersForAMovieByTMDBId(tmdbId));
        }

        return movieShortList;
    }

    public List<MediaShort> getTrending() {
        log.info("Requesting trending shows for last week.");
        List<MediaShort> trending = tmdb.getTrending();
        if (trending == null) {
            log.warn("Failed retrieving trending movies from TMDB.");
        }
        return trending;
    }
}


