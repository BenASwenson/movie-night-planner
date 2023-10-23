package com.sparta.movieplanner.justwatch.controller;

import com.sparta.movieplanner.justwatch.dto.ProviderDTO;
import com.sparta.movieplanner.justwatch.entity.Movie;
import com.sparta.movieplanner.justwatch.entity.Provider;
import com.sparta.movieplanner.justwatch.service.MovieService;
import com.sparta.movieplanner.justwatch.service.ProviderService;
import com.sparta.movieplanner.justwatch.service.ShowService;
import jakarta.transaction.Transactional;
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

    @Autowired
    private ShowService showService;

    @Autowired
    private ProviderService providerService;

    @GetMapping("movies")
    public Movie getMovie(@RequestParam String title, @RequestParam int year) throws IOException, InterruptedException {
        System.out.println(title);
        System.out.println(year);

        return movieService.findMovieByTitleAndReleaseYear(title, year);
    }

    @GetMapping("movies/providers")
    public List<ProviderDTO> getMovieProvidersByTMDBId(@RequestParam int id) throws IOException, InterruptedException {
        return movieService.findAllProvidersForAMovieByTMDBId(id);
    }

    @GetMapping("show/providers")
    public List<ProviderDTO> getShowProvidersByTMDBId(@RequestParam int id) throws IOException, InterruptedException {
        return showService.findAllShowProvidersByTMDBId(id);
    }

    @GetMapping("/justwatch/providers")
    public List<Provider> getAllProviders(){
        return providerService.getAllProviders();
    }

    /*
        Only run when providers table needs to be updated. Delete and create table again before running this.
    */
    @GetMapping("/justwatch/providers/save")
    @Transactional
    public List<Provider> saveJustWatchProviders() throws IOException, InterruptedException {
        return providerService.saveAllProviders();
    }
}
