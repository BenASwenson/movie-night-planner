package com.sparta.movieplanner.tmdb;

import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonProperty;


public class MovieShort {
    public int id;
    public boolean adult;
    public String backdrop_path;
    public ArrayList<Integer> genre_ids;
    public String title;
    public String overview;
    public String original_title;
    public String original_language;
    public double popularity;
    public String poster_path;
    public String release_date;
    public boolean video;
    public double vote_average;
    public int vote_count;
}
