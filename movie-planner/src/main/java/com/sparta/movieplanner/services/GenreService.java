package com.sparta.movieplanner.services;

import com.sparta.movieplanner.converters.GenreConverter;
import com.sparta.movieplanner.dto.GenreDTO;
import com.sparta.movieplanner.tmdb.Genre;
import com.sparta.movieplanner.tmdb.MediaShort;
import com.sparta.movieplanner.tmdb.Tmdb;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GenreService {
    Logger log = LoggerFactory.getLogger(getClass());
    private final Tmdb tmdb;

    public GenreService(Tmdb tmdb) {
        this.tmdb = tmdb;
    }

    public List<GenreDTO> getAllGenres() {
        List<Genre> genres = tmdb.getGenres();
        List<GenreDTO> dtoGenres = new ArrayList<>();
        for (Genre g : genres) {
            dtoGenres.add(GenreConverter.entityToDto(g));
        }
        return dtoGenres;
    }

    public List<MediaShort> getMoviesByGenre(List<Integer> genreIds) {
        return tmdb.findMoviesByGenres(genreIds);
    }

    public List<MediaShort> getMoviesByGenre(int genreId) {
        List<Integer> genres = new ArrayList<>();
        genres.add(genreId);
        return getMoviesByGenre(genres);
    }
}
