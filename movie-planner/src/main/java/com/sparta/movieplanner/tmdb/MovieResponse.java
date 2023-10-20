package com.sparta.movieplanner.tmdb;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class MovieResponse {


    public int page;


    public ArrayList<MovieShort> results;
}
