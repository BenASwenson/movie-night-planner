package com.sparta.movieplanner.services;

import com.sparta.movieplanner.dto.MovieDTO;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MovieService {

    public List<MovieDTO> findMoviesByQuery(String query) {
        // TODO: Use Tmdb class to pull data from movie, credit, person and glue
        // them together into a MovieDTO list.
        return null;
    }
}

