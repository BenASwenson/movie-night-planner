package com.sparta.movieplanner.services;

import com.sparta.movieplanner.converters.MovieShortConverter;
import com.sparta.movieplanner.dto.MovieDTO;
import com.sparta.movieplanner.tmdb.MediaShort;
import com.sparta.movieplanner.tmdb.Tmdb;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
    Logger log = LoggerFactory.getLogger(getClass());
    private final Tmdb tmdb;

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

    public List<MediaShort> findMoviesByTitle(String title) {
        log.info("find movies by title method active");
        // TODO: Use Tmdb class to pull data from movie, credit, person and glue them together into a MovieDTO list.

        List<MediaShort> movieShortList = tmdb.findMovies(title);


        return movieShortList;
    }
}


