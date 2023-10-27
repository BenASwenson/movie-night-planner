package com.sparta.movieplanner.converters;

import com.sparta.movieplanner.dto.GenreDTO;
import com.sparta.movieplanner.tmdb.Genre;

public class GenreConverter {
    static public GenreDTO entityToDto(Genre genre) {
        return new GenreDTO(genre.getId(), genre.getName());
    }
}
