package com.sparta.movieplanner.converters;

import com.sparta.movieplanner.dto.MovieDTO;
import com.sparta.movieplanner.tmdb.MovieShort;

public class MovieShortConverter implements Converter<MovieDTO, MovieShort>{

    @Override
    public MovieShort dtoToEntity(MovieDTO movieDTO) {
        return new MovieShort(movieDTO.getId(),
                movieDTO.getTitle(),
                movieDTO.getOverview(),
                movieDTO.getPoster_path());
    }

    @Override
    public MovieDTO entityToDto(MovieShort movieShort) {

        return new MovieDTO(movieShort.getId(),
                movieShort.getTitle(),
                movieShort.getOverview(),
                movieShort.getPoster_path());
    }

}
