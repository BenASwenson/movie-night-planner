package com.sparta.movieplanner.services;

import com.sparta.movieplanner.tmdb.MediaShort;
import com.sparta.movieplanner.tmdb.Tmdb;
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

    public List<MediaShort> findTelevisionByTitle(String title) {
        log.info("find television by title method active");

        List<MediaShort> tvShortList = tmdb.findTV(title);

        return tvShortList;
    }
}
