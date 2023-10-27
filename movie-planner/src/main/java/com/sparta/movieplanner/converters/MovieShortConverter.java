package com.sparta.movieplanner.converters;

import com.sparta.movieplanner.dto.MovieDTO;
import com.sparta.movieplanner.tmdb.MediaShort;

public class MovieShortConverter implements Converter<MovieDTO, MediaShort>{

    @Override
    public MediaShort dtoToEntity(MovieDTO movieDTO) {
        MediaShort mediaShort = new MediaShort();
        mediaShort.setId(movieDTO.getId());
        mediaShort.setTitle(movieDTO.getTitle());
        mediaShort.setOverview(movieDTO.getOverview());
        mediaShort.setPoster_path(movieDTO.getPoster_path());
        return mediaShort;
    }

    @Override
    public MovieDTO entityToDto(MediaShort movieShort) {

        return new MovieDTO(movieShort.getId(),
                movieShort.getTitle(),
                movieShort.getOverview(),
                movieShort.getPoster_path());
    }

}
