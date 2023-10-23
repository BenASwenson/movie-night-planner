package com.sparta.movieplanner.tmdb;

import java.util.ArrayList;

public class TvEpisodeDetail {

    private  String air_date; // ": "2006-06-03",
    private ArrayList<CreditShort> crew;
    private  int episode_number;
    private  ArrayList<CreditShort> guest_stars;
    private  String name;
    private  String overview;
    private  long id;
    private  String production_code;
    private  int runtime;
    private  int season_number;
    private  String still_path;
    private  double vote_average;
    private  int vote_count;

    public String getAir_date() {
        return air_date;
    }

    public void setAir_date(String air_date) {
        this.air_date = air_date;
    }

    public ArrayList<CreditShort> getCrew() {
        return crew;
    }

    public void setCrew(ArrayList<CreditShort> crew) {
        this.crew = crew;
    }

    public int getEpisode_number() {
        return episode_number;
    }

    public void setEpisode_number(int episode_number) {
        this.episode_number = episode_number;
    }

    public ArrayList<CreditShort> getGuest_stars() {
        return guest_stars;
    }

    public void setGuest_stars(ArrayList<CreditShort> guest_stars) {
        this.guest_stars = guest_stars;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProduction_code() {
        return production_code;
    }

    public void setProduction_code(String production_code) {
        this.production_code = production_code;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public int getSeason_number() {
        return season_number;
    }

    public void setSeason_number(int season_number) {
        this.season_number = season_number;
    }

    public String getStill_path() {
        return still_path;
    }

    public void setStill_path(String still_path) {
        this.still_path = still_path;
    }

    public double getVote_average() {
        return vote_average;
    }

    public void setVote_average(double vote_average) {
        this.vote_average = vote_average;
    }

    public int getVote_count() {
        return vote_count;
    }

    public void setVote_count(int vote_count) {
        this.vote_count = vote_count;
    }

    @Override
    public String toString() {
        return "TvEpisodeDetail{" +
                "id=" + id +
                ", season_number=" + season_number +
                ", name='" + name + '\'' +
                ", air_date='" + air_date + '\'' +
                '}';
    }
}
