package com.sparta.movieplanner.justwatch.service;

import com.sparta.movieplanner.justwatch.dto.ProviderDTO;
import com.sparta.movieplanner.justwatch.entity.Movie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MovieServiceTest {
    @Autowired
    private MovieService movieService;
    Movie movie;
    @BeforeAll
    public void setup() throws IOException, InterruptedException {
        movie = movieService.findMovieByTMDBId(299536);
    }

    @Test
    void testFindMovieByTMDBId() throws IOException, InterruptedException {
        Assertions.assertNotNull(movie);
    }

    @Test
    void testMovieTitle(){
        String actual = movie.getTitle();
        String expected = "Avengers: Infinity War";
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void testMovieReleaseYear(){
        int actual = movie.getOriginal_release_year();
        int expected = 2018;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testMovieProviders() throws IOException, InterruptedException {
        List<ProviderDTO> result = movieService.findAllProvidersForAMovieByTMDBId(299536);

        Assertions.assertNotNull(result);
    }
}
