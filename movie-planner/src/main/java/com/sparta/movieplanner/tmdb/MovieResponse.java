package com.sparta.movieplanner.tmdb;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class MovieResponse {

    @JsonProperty("page")
    public int page;

    @JsonProperty("results")
    public ArrayList<MovieShort> results;
}
