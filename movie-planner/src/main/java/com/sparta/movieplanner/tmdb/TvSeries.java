package com.sparta.movieplanner.tmdb;

import java.util.ArrayList;

public class TvSeries {
    private boolean adult;
    private String backdrop_path;// jpg(image)

    public static class Credit {
        private int id;
        private String credit_id;
        private String name;
        private int gender;
        private String profile_path; // "/2mAjcq9AQA9peQxNoeEW76DPIju.jpg"

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCredit_id() {
            return credit_id;
        }

        public void setCredit_id(String credit_id) {
            this.credit_id = credit_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public String getProfile_path() {
            return profile_path;
        }

        public void setProfile_path(String profile_path) {
            this.profile_path = profile_path;
        }

        @Override
        public String toString() {
            return "Credit{" +
                    "id=" + id +
                    ", credit_id='" + credit_id + '\'' +
                    ", name='" + name + '\'' +
                    ", gender=" + gender +
                    ", profile_path='" + profile_path + '\'' +
                    '}';
        }
    }

    private ArrayList<Credit> created_by;

    private ArrayList<Integer> episode_run_time;

    private String first_air_date;
    private ArrayList<Genre> genres;

    private String homepage;
    private int id;
    private boolean in_production;
    private ArrayList<String> languages;

    private String last_air_date;

    public static class Episode {
        private int id;
        private String name;
        private String overview;
        private double vote_average;
        private int vote_count;
        private String air_date;
        private int episode_number;
        private String episode_type;
        private String production_code;
        private int runtime;
        private int season_number;
        private int show_id;
        private String still_path; // "/hY3floabgHaJfcH3sgd1SRYy810.jpg"

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

        @Override
        public String toString() {
            return "Episode{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
    private Episode last_episode_to_air;

    private String name;

    private Episode next_episode_to_air;

    public static class Network {
        private int id;
        private String logo_path; // "/2uy2ZWcplrSObIyt4x0Y9rkG6qO.png"
        private String name;
        private String origin_country;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getLogo_path() {
            return logo_path;
        }

        public void setLogo_path(String logo_path) {
            this.logo_path = logo_path;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getOrigin_country() {
            return origin_country;
        }

        public void setOrigin_country(String origin_country) {
            this.origin_country = origin_country;
        }

        @Override
        public String toString() {
            return "Network{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
    private ArrayList<Network> networks;

    private int number_of_episodes;
    private int number_of_seasons;

    private ArrayList<String> origin_country;

    private String original_language;
    private String original_name;
    private String overview;
    private double popularity;
    private String poster_path;

    private ArrayList<Company> production_companies;

    public static class Country {
        private String iso_3166_1;
        private String name;

        public String getIso_3166_1() {
            return iso_3166_1;
        }

        public void setIso_3166_1(String iso_3166_1) {
            this.iso_3166_1 = iso_3166_1;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Country{" +
                    "iso_3166_1='" + iso_3166_1 + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    private ArrayList<Country> production_countries;

    public static class Season {
        private String air_date;
        private int episode_count;
        private int id;
        private String name;
        private String overview;
        private String poster_path;
        private int season_number;
        private double vote_average;

        public String getAir_date() {
            return air_date;
        }

        public void setAir_date(String air_date) {
            this.air_date = air_date;
        }

        public int getEpisode_count() {
            return episode_count;
        }

        public void setEpisode_count(int episode_count) {
            this.episode_count = episode_count;
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

        public double getVote_average() {
            return vote_average;
        }

        public void setVote_average(double vote_average) {
            this.vote_average = vote_average;
        }

        @Override
        public String toString() {
            return "Season{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
    private ArrayList<Season> seasons;

    private ArrayList<Language> spoken_languages;

    private String status;
    private String tagline;
    private String type;
    private double vote_average;
    private int vote_count;


    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public ArrayList<Credit> getCreated_by() {
        return created_by;
    }

    public void setCreated_by(ArrayList<Credit> created_by) {
        this.created_by = created_by;
    }

    public ArrayList<Integer> getEpisode_run_time() {
        return episode_run_time;
    }

    public void setEpisode_run_time(ArrayList<Integer> episode_run_time) {
        this.episode_run_time = episode_run_time;
    }

    public String getFirst_air_date() {
        return first_air_date;
    }

    public void setFirst_air_date(String first_air_date) {
        this.first_air_date = first_air_date;
    }

    public ArrayList<Genre> getGenres() {
        return genres;
    }

    public void setGenres(ArrayList<Genre> genres) {
        this.genres = genres;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isIn_production() {
        return in_production;
    }

    public void setIn_production(boolean in_production) {
        this.in_production = in_production;
    }

    public ArrayList<String> getLanguages() {
        return languages;
    }

    public void setLanguages(ArrayList<String> languages) {
        this.languages = languages;
    }

    public String getLast_air_date() {
        return last_air_date;
    }

    public void setLast_air_date(String last_air_date) {
        this.last_air_date = last_air_date;
    }

    public Episode getLast_episode_to_air() {
        return last_episode_to_air;
    }

    public void setLast_episode_to_air(Episode last_episode_to_air) {
        this.last_episode_to_air = last_episode_to_air;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Episode getNext_episode_to_air() {
        return next_episode_to_air;
    }

    public void setNext_episode_to_air(Episode next_episode_to_air) {
        this.next_episode_to_air = next_episode_to_air;
    }

    public ArrayList<Network> getNetworks() {
        return networks;
    }

    public void setNetworks(ArrayList<Network> networks) {
        this.networks = networks;
    }

    public int getNumber_of_episodes() {
        return number_of_episodes;
    }

    public void setNumber_of_episodes(int number_of_episodes) {
        this.number_of_episodes = number_of_episodes;
    }

    public int getNumber_of_seasons() {
        return number_of_seasons;
    }

    public void setNumber_of_seasons(int number_of_seasons) {
        this.number_of_seasons = number_of_seasons;
    }

    public ArrayList<String> getOrigin_country() {
        return origin_country;
    }

    public void setOrigin_country(ArrayList<String> origin_country) {
        this.origin_country = origin_country;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getOriginal_name() {
        return original_name;
    }

    public void setOriginal_name(String original_name) {
        this.original_name = original_name;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public ArrayList<Company> getProduction_companies() {
        return production_companies;
    }

    public void setProduction_companies(ArrayList<Company> production_companies) {
        this.production_companies = production_companies;
    }

    public ArrayList<Country> getProduction_countries() {
        return production_countries;
    }

    public void setProduction_countries(ArrayList<Country> production_countries) {
        this.production_countries = production_countries;
    }

    public ArrayList<Season> getSeasons() {
        return seasons;
    }

    public void setSeasons(ArrayList<Season> seasons) {
        this.seasons = seasons;
    }

    public ArrayList<Language> getSpoken_languages() {
        return spoken_languages;
    }

    public void setSpoken_languages(ArrayList<Language> spoken_languages) {
        this.spoken_languages = spoken_languages;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        return "TvSeries{" +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
