package com.sparta.movieplanner.tmdb;

import java.util.ArrayList;

public class MovieCreditResponse {

    private int id;
    private ArrayList<CreditShort> cast;
    private ArrayList<CreditShort> crew;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<CreditShort> getCast() {
        return cast;
    }

    public void setCast(ArrayList<CreditShort> cast) {
        this.cast = cast;
    }

    public ArrayList<CreditShort> getCrew() {
        return crew;
    }

    public void setCrew(ArrayList<CreditShort> crew) {
        this.crew = crew;
    }

    @Override
    public String toString() {
        return "MovieCreditResponse{" +
                "id=" + id +
                ", cast=" + cast +
                ", crew=" + crew +
                '}';
    }
}
