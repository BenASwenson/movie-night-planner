package com.sparta.movieplanner.services;

import com.sparta.movieplanner.tmdb.MovieShort;
import com.sparta.movieplanner.tmdb.Tmdb;
import com.sparta.movieplanner.tmdb.TvShort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TelevisionService {
    Logger log = LoggerFactory.getLogger(getClass());

    private final Tmdb tmdb;

    public TelevisionService(Tmdb tmdb) {
        this.tmdb = tmdb;
    }

    public List<TvShort> findTelevisionByTitle(String title) {
        log.info("find television by title method active");

        List<TvShort> tvShortList = tmdb.findTV(title);

        return tvShortList;
    }
}
