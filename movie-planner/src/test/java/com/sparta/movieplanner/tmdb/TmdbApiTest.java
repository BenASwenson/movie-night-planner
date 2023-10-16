package com.sparta.movieplanner.tmdb;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;
// import com.sparta.movieplanner.tmdb.Genre;

import com.sparta.movieplanner.tmdb.Genre;

public class TmdbApiTest {
    @Test
    void genreTest() { 
        String url = "https://api.themoviedb.org/3/genre/movie/list?api_key=2e778d5f31e240b493d778371b6bbcb8";
        RestTemplate restTemplate = new RestTemplate();
        
        GenreResponse response = restTemplate.getForObject(url, GenreResponse.class);
        for(Genre g: response.genres){
            System.out.println("Id = " + g.id + " name = " + g.name);
        }
        

    }
    
}
