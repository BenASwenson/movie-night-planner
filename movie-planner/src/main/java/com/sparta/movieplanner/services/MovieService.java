package com.sparta.movieplanner.services;

import com.sparta.movieplanner.converters.MovieShortConverter;
import com.sparta.movieplanner.dto.MovieDTO;
import com.sparta.movieplanner.tmdb.MovieShort;
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
        List<MovieShort> movies = tmdb.findMovies(query);
        List<MovieDTO> movieDTOs = new ArrayList<>();
        for(MovieShort movie : movies) {
            movieDTOs.add(new MovieShortConverter().entityToDto(movie));
        }
        return movieDTOs;

    }

    public List<MovieShort> findMoviesByTitle(String title) {
        log.info("find movies by title method active");
        // TODO: Use Tmdb class to pull data from movie, credit, person and glue them together into a MovieDTO list.

        List<MovieShort> movieShortList = tmdb.findMovies(title);


        return movieShortList;
    }
}


