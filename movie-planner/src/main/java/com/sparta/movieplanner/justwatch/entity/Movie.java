package com.sparta.movieplanner.justwatch.entity;

import java.util.List;

public class Movie {
    private String title;
    private int original_release_year;
    private int runtime;



    private List<Offers> offers;

    public Movie(){}

    public Movie(String title, int original_release_year, int runtime, List<Offers> offers) {
        this.title = title;
        this.original_release_year = original_release_year;
        this.runtime = runtime;
        this.offers = offers;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getOriginal_release_year() {
        return original_release_year;
    }

    public void setOriginal_release_year(int original_release_year) {
        this.original_release_year = original_release_year;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public List<Offers> getOffers() {
        return offers;
    }

    public void setOffers(List<Offers> offers) {
        this.offers = offers;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", original_release_year=" + original_release_year +
                ", runtime=" + runtime +
                ", offers=" + offers +
                '}';
    }
}