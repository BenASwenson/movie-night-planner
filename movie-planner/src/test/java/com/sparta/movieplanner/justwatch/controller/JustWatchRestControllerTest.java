package com.sparta.movieplanner.justwatch.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sparta.movieplanner.justwatch.entity.Movie;
import com.sparta.movieplanner.justwatch.entity.Show;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;

public class JustWatchRestControllerTest {
    ObjectMapper mapper = JsonMapper.builder()
            .addModule(new JavaTimeModule())
            .build();

    @Test
    void getMovieByTitleAndReleaseYearTest(){
        Movie result = null;

        try{
            result = mapper.readValue(new URL("http://localhost:8080/justwatch/movies?title=Avengers:%20Infinity%20War&year=2019"), Movie.class);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
        String title = result.getTitle();
        int releaseYear = result.getOriginal_release_year();

        Assertions.assertEquals("Avengers: Infinity War", title);
        Assertions.assertEquals(2018, releaseYear);
    }

    @Test
    void getMovieByTMDBIdTest(){
        Movie result = null;

        try{
            result = mapper.readValue(new URL("http://localhost:8080/justwatch/movies/299536"), Movie.class);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
        String title = result.getTitle();
        int releaseYear = result.getOriginal_release_year();

        Assertions.assertEquals("Avengers: Infinity War", title);
        Assertions.assertEquals(2018, releaseYear);
    }

    @Test
    void getShowByTMDBIdTest(){
        Show result = null;

        try{
            result = mapper.readValue(new URL("http://localhost:8080/justwatch/show/1399"), Show.class);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
        String title = result.getTitle();
        int releaseYear = result.getOriginal_release_year();

        Assertions.assertEquals("Game of Thrones", title);
        Assertions.assertEquals(2011, releaseYear);
    }
}
