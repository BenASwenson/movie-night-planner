package com.sparta.movieplanner.justwatch.controller;

import com.sparta.movieplanner.justwatch.entity.Movie;
import com.sparta.movieplanner.justwatch.entity.Provider;
import com.sparta.movieplanner.justwatch.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class JustWatchRestController {

    @Autowired
    private MovieService movieService;

    @GetMapping("movie")
    public Movie getMovie(@RequestParam String title, @RequestParam int year) throws IOException, InterruptedException {
        System.out.println(title);
        System.out.println(year);

        return movieService.findMovieByTitleAndReleaseYear(title, year);
    }

    @GetMapping("movie/providers")
    public List<Provider> getMovieProviders(@RequestParam int id) throws IOException, InterruptedException {
        return movieService.findAllProvidersForAMovieByTMDBId(id);
    }
}
