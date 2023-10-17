package com.sparta.movieplanner.tmdb;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import com.sparta.movieplanner.tmdb.Genre;

// @SpringBootTest
public class TmdbApiTest {

    static final String key = "2e778d5f31e240b493d778371b6bbcb8";

    @Test
    void genreTest() {
        // TODO: Refactor the below into a Tmdb java api class.
        WebClient client = WebClient.create("https://api.themoviedb.org");
        Mono<GenreResponse> response = client.get()
                .uri("/3/genre/movie/list?api_key={key}", key)
                .retrieve()
                .bodyToMono(GenreResponse.class);

        GenreResponse genreResponse = response.block();
        for(Genre g: genreResponse.genres){
            System.out.println("Id = " + g.id + " name = " + g.name);
        }
    }

}
