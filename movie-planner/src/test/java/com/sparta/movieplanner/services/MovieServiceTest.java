package com.sparta.movieplanner.services;

import com.sparta.movieplanner.tmdb.MediaShort;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertTrue;

@SpringBootTest
public class MovieServiceTest {
    @Autowired
    MovieService movieService;
    @Test
    @DisplayName("Given a search query (movie title), return a list of movies containing the query")
    public void findListOfMoviesByTitle() throws IOException, InterruptedException {
        List<MediaShort> movieLists = movieService.findMoviesByTitle("Star Wars");

        assertTrue(movieLists.size() > 0);
    }

}
