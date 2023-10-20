package com.sparta.movieplanner.justwatch.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sparta.movieplanner.justwatch.dto.ProviderDTO;
import com.sparta.movieplanner.justwatch.entity.Movie;
import com.sparta.movieplanner.justwatch.entity.Provider;

import java.io.IOException;
import java.util.List;

public interface MovieService {

    Movie findMovieByTitleAndReleaseYear(String title, int year) throws IOException, InterruptedException;

    Movie findMovieByTMDBId(int id) throws IOException, InterruptedException;

    List<ProviderDTO> findAllProvidersForAMovieByTMDBId(int id) throws IOException, InterruptedException;
}
