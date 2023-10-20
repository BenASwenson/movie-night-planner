package com.sparta.movieplanner.tmdb;

import org.junit.jupiter.api.Test;
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
        List<MovieShort> results = tmdb.findMovies("Star Wars");
        for (MovieShort s : results) {
            System.out.println("movie: " + s.getTitle()+ " id=" + s.getId());
        }

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
        List<TvShort> results = tmdb.findTV("Friends");
        System.out.println(results);
    }

    @Test
    void getTvSeries() {
        TvSeries results = tmdb.getTvSeries(2);
        System.out.println(results);
    }

    @Test
    void getTvSeason() {
        TvSeason result = tmdb.getTvSeason(121, 2); // Dr Who
        System.out.println(result);
    }
}

