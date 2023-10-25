package com.sparta.movieplanner.tmdb;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class TmdbApiTest {

    static final String key = "2e778d5f31e240b493d778371b6bbcb8";

    Tmdb tmdb = new Tmdb();

    @Test
    void genreTest() {
        List<Genre> genres = tmdb.getGenres();
        for(Genre g: genres) {
            System.out.println("Id = " + g.getId() + " name = " + g.getName());
        }
    }

    @Test
    void queryTmdbMoviesTest() {
        List<MediaShort> results = tmdb.findMovies("Star Wars");
        for (MediaShort s : results) {
            System.out.println("movie: " + s.getTitle()+ " id=" + s.getId());
        }
    }

    @Test
    void getMovieDetailTest() {
        MovieDetail result = tmdb.getMovieDetail(11); // star wars
        System.out.println(result);
    }

    @Test
    void movieCreditResponseTest() {
        MovieCreditResponse credits = tmdb.findCreditsByMovieId(11);
        System.out.println(credits);
    }

    @Test
    void getPersonByIdTest() {
        Person person = tmdb.getPersonById(8);
        System.out.println(person);
    }

    @Test
    void getListOfTV() {
        List<MediaShort> results = tmdb.findTV("Friends");
        System.out.println(results);
    }

    @Test
    void getTvSeries() {
        TvSeries results = tmdb.getTvSeries(1668);
        System.out.println(results);
    }

    @Test
    void getTvSeason() {
        TvSeason result = tmdb.getTvSeason(121, 2);
        System.out.println(result);
    }

    @Test
    void getTvEpisodeDetail() {
        TvEpisodeDetail result = tmdb.getTvEpisodeDetail(121, 2, 1);
        System.out.println(result);
    }

    @Test
    void getTrendingTest() {
        List<MediaShort> result = tmdb.getTrending();
        System.out.println(result);
    }

    @Test
    void testFindShowsByGenre() {
        List<MediaShort> result = tmdb.findMoviesByGenres(Lists.list(12,28));
        System.out.println(result);
    }
}

