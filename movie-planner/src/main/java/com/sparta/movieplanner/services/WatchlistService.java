package com.sparta.movieplanner.services;

import com.sparta.movieplanner.tmdb.MediaShort;
import com.sparta.movieplanner.tmdb.Tmdb;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WatchlistService {
    Logger log = LoggerFactory.getLogger(getClass());
    private Tmdb tmdb;

    private MovieService movieService;

    //TODO: might need to use movie service to get movies
}
