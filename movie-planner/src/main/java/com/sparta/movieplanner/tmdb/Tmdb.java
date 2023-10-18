package com.sparta.movieplanner.tmdb;

import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

public class Tmdb {

    private final String urlBase = "https://api.themoviedb.org";

    // TODO: move to the property file.
    static final String key = "2e778d5f31e240b493d778371b6bbcb8";


    WebClient client;

    public Tmdb() {
        client = WebClient.create(urlBase);
    }

    /**
     * Find all movies that have the 'query' in their title.
     * @param query
     * @return list of movies
     */
    public List<MovieShort> findMovies(String query) {

        Mono<MovieResponse> result = client.get()
                .uri("/3/search/movie?query={query}&include_adult=false&language=en-US&page=1&api_key={key}",
                        query, key)
                .retrieve()
                .bodyToMono(MovieResponse.class);
        MovieResponse response = result.block();
        if (response == null) {
            return null;
        }
        return response.results;
    }

    public MovieCreditResponse findCreditsByMovieId(int id) {

        Mono<MovieCreditResponse> result = client.get()
                .uri("/3/movie/{id}/credits?api_key={key}",
                        id, key)
                .retrieve()
                .bodyToMono(MovieCreditResponse.class);
        return result.block();

    }

    /**
     * Retrieve all genres available in TMDB.
     * @return list of Genres
     */
    public List<Genre> getGenres() {

        Mono<GenreResponse> response = client.get()
                .uri("/3/genre/movie/list?api_key={key}", key)
                .retrieve()
                .bodyToMono(GenreResponse.class);
        GenreResponse result = response.block();
        if (result == null) {
            return null;
        }
        return result.genres;
    }

    public Person getPersonById(int id) {

        Mono<Person> result = client.get()
                .uri("/3/person/{person_id}?api_key={key}",
                        id, key)
                .retrieve()
                .bodyToMono(Person.class);
        return result.block();

    }
}
