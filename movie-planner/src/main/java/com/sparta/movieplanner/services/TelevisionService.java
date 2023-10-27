package com.sparta.movieplanner.services;

import com.sparta.movieplanner.justwatch.service.MovieService;
import com.sparta.movieplanner.justwatch.service.ShowService;
import com.sparta.movieplanner.tmdb.MediaShort;
import com.sparta.movieplanner.tmdb.Tmdb;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;


@Service
public class TelevisionService {
    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private ShowService justWatchShowService;

    private final Tmdb tmdb;

    public TelevisionService(Tmdb tmdb) {
        this.tmdb = tmdb;
    }

    public List<MediaShort> findTelevisionByTitle(String title) throws IOException, InterruptedException {
        log.info("find television by title method active");

        List<MediaShort> tvShortList = tmdb.findTV(title);

        // Find all providers for each movie and add it to the list
        for(int i = 0; i < tvShortList.size(); i++){
            int tmdbId = tvShortList.get(i).getId();
            tvShortList.get(i).setProviders(justWatchShowService.findAllShowProvidersByTMDBId(tmdbId));
        }

        return tvShortList;
    }
}
