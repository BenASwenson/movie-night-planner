package com.sparta.movieplanner.justwatch.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sparta.movieplanner.justwatch.entity.Movie;

import java.io.IOException;

public interface MovieService {

    Movie findMovieByTitleAndReleaseYear(String title, int year) throws IOException, InterruptedException;
}
