package com.sparta.movieplanner.tmdb;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
@Component
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
     *
     * @param query
     * @return list of movies
     */
    public List<MediaShort> findMovies(String query) {

        Mono<MediaResponse> result = client.get()
                .uri("/3/search/movie?query={query}&include_adult=false&language=en-US&page=1&api_key={key}",
                        query, key)
                .retrieve()
                .bodyToMono(MediaResponse.class);
        MediaResponse response = result.block();
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

    public MovieDetail getMovieDetail(int movie_id) {
        Mono<MovieDetail> result = client.get()
                .uri("3/movie/{movie_id}?api_key={key}",
                        movie_id, key)
                .retrieve()
                .bodyToMono(MovieDetail.class);
        return result.block();
    }

    /**
     * Retrieve all genres available in TMDB.
     *
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

    public List<MediaShort> findTV(String query) {

        Mono<TvResponse> result = client.get()
                .uri("/3/search/tv?query={query}&include_adult=false&language=en-US&page=1&api_key={key}",
                        query, key)
                .retrieve()
                .bodyToMono(TvResponse.class);
        TvResponse response = result.block();
        if (response == null) {
            return null;
        }
        return response.getResults();
    }

    public TvSeries getTvSeries(int id) {
        Mono<TvSeries> result = client.get()
                .uri("/3/tv/{series_id}?api_key={key}",
                        id, key)
                .retrieve()
                .bodyToMono(TvSeries.class);
        return result.block();
    }

    public TvSeason getTvSeason(int seriesId, int seasonNumber) {
        Mono<TvSeason> result = client.get()
                .uri("/3/tv/{series_id}/season/{season_number}?api_key={key}",
                        seriesId, seasonNumber, key)
                .retrieve()
                .bodyToMono(TvSeason.class);
        return result.block();
    }

    public TvEpisodeDetail getTvEpisodeDetail(int seriesId, int seasonNumber, int episodeNumber) {
        Mono<TvEpisodeDetail> result = client.get()
                .uri("/3/tv/{series_id}/season/{season_number}/episode/{episode_number}?api_key={key}",
                        seriesId, seasonNumber, episodeNumber, key)
                .retrieve()
                .bodyToMono(TvEpisodeDetail.class);
        return result.block();
    }

    public static class RequestTrendingResponse {
        public int page;
        public ArrayList<MediaShort> results;
        public int total_pages;
        public long total_results;
    }

    public List<MediaShort> getTrending() {

        Mono<RequestTrendingResponse> monoResponse = client.get()
                .uri("/3/trending/all/week?language=en-US&api_key={key}",
                        key)
                .retrieve()
                .bodyToMono(RequestTrendingResponse.class);
        RequestTrendingResponse response = monoResponse.block();
        if (response == null) {
            return null;
        }
        return response.results;
    }

    public List<MediaShort> findMoviesByGenres(List<Integer> genreList) {
        StringBuilder genres = new StringBuilder();

        for (int i=0; i<genreList.size(); i++) {
            genres.append(genreList.get(i).toString());
            if (i< genreList.size() -1) {
                genres.append("|"); // | means OR
            }
        }

        MediaResponse response = client.get()
                .uri("/3/discover/movie?with_genres={genres}&api_key={key}",
                        genres.toString(), key)
                .retrieve()
                .bodyToMono(MediaResponse.class)
                .block();
        if (response == null) {
            return null;
        }

        return response.results;
    }


}
