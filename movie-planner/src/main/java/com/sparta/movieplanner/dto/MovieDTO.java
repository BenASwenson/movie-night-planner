package com.sparta.movieplanner.dto;

import com.sparta.movieplanner.tmdb.Genre;

import java.util.List;

public class MovieDTO {
    // TODO: fill with relevant fields: title, tagline, list of credits and people, etc.
    private int movieId;
    private String title;
    private String description;
    private String releaseDate;

    // rating might not be double??
    private double rating;

    // ageRating might be string instead of int??
    private int ageRating;
    private String director;
    private List<Genre> genresList;

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getAgeRating() {
        return ageRating;
    }

    public void setAgeRating(int ageRating) {
        this.ageRating = ageRating;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public List<Genre> getGenresList() {
        return genresList;
    }

    public void setGenresList(List<Genre> genresList) {
        this.genresList = genresList;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "MovieDTO{" +
                "movieId=" + movieId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", rating=" + rating +
                ", ageRating=" + ageRating +
                ", director='" + director + '\'' +
                ", genresList=" + genresList +
                '}';
    }
}
