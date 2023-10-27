package com.sparta.movieplanner.tmdb;

import java.util.ArrayList;

public class TvSeason {

    private String _id;
    private String air_date;

    private ArrayList<TvEpisode> episodes;

    public static class TvEpisode {

        private String air_date;
        private int episode_number;
        private String episode_type;
        private int id;
        private String name;
        private String overview;
        private String production_code;
        private int runtime;
        private int season_number;
        private int show_id;
        private String still_path;
        private double vote_average;
        private int vote_count;
        // private ArrayList<Crew> crew
        // private ArrayList<Guest> guest_stars; // ": [

        public String getAir_date() {
            return air_date;
        }

        public void setAir_date(String air_date) {
            this.air_date = air_date;
        }

        public int getEpisode_number() {
            return episode_number;
        }

        public void setEpisode_number(int episode_number) {
            this.episode_number = episode_number;
        }

        public String getEpisode_type() {
            return episode_type;
        }

        public void setEpisode_type(String episode_type) {
            this.episode_type = episode_type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
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

        public int getShow_id() {
            return show_id;
        }

        public void setShow_id(int show_id) {
            this.show_id = show_id;
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
            return "TvEpisode{" +
                    "air_date='" + air_date + '\'' +
                    ", episode_number=" + episode_number +
                    ", id=" + id +
                    ", name='" + name + '\'' +
                    ", season_number=" + season_number +
                    ", show_id=" + show_id +
                    '}';
        }
    }

    private String name;
    private String overview;
    private int id;
    private String poster_path;
    private int season_number;
    private int vote_average;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getAir_date() {
        return air_date;
    }

    public void setAir_date(String air_date) {
        this.air_date = air_date;
    }

    public ArrayList<TvEpisode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(ArrayList<TvEpisode> episodes) {
        this.episodes = episodes;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public int getSeason_number() {
        return season_number;
    }

    public void setSeason_number(int season_number) {
        this.season_number = season_number;
    }

    public int getVote_average() {
        return vote_average;
    }

    public void setVote_average(int vote_average) {
        this.vote_average = vote_average;
    }

    @Override
    public String toString() {
        return "TvSeason{" +
                " id=" + id +
                ", name='" + name + '\'' +
                ", season_number=" + season_number +
                '}';
    }
}