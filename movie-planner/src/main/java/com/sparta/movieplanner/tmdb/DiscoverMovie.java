package com.sparta.movieplanner.tmdb;

import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

// https://developer.themoviedb.org/reference/discover-movie
public class DiscoverMovie {
    private final String urlBase = "https://api.themoviedb.org";

    static final String key = "2e778d5f31e240b493d778371b6bbcb8";

    private String language = "en-US";
    private Integer page;
    private Integer primary_release_year;
    private String region;
    private String release_date_gte;
    private String release_date_lte;


    private SortBy sortBy;

    private String watch_region;

    private String with_origin_country;
    private String with_original_language;

    private Integer year;

    public enum SortBy {
        PopularityDesc("popularity.desc"),
        PopularityAsc("popularity.asc"),
        RevenueAsc("revenue.asc"),
        RevenueDesc("revenue.desc"),
        PrimaryReleaseDateAsc("primary_release_date.asc"),
        PrimaryReleaseDateDesc("primary_release_date.desc"),
        VoteAverageAsc("vote_average.asc"),
        VoteAverageDesc("vote_average.desc"),
        VoteCountAsc("vote_count.asc"),
        VoteCountDesc("vote_count.desc")
        ;

        private SortBy(String sort) {
            this.sort = sort;
        }

        public final String sort;
    }



    public DiscoverMovie setLanguage(String language) {
        this.language = language;
        return this;
    }

    public DiscoverMovie atPage(Integer page) {
        this.page = page;
        return this;
    }

    public DiscoverMovie setPrimary_release_year(Integer primary_release_year) {
        this.primary_release_year = primary_release_year;
        return this;
    }

    public DiscoverMovie setRegion(String region) {
        this.region = region;
        return this;
    }

    public DiscoverMovie setRelease_date_gte(String release_date_gte) {
        this.release_date_gte = release_date_gte;
        return this;
    }

    public DiscoverMovie setRelease_date_lte(String release_date_lte) {
        this.release_date_lte = release_date_lte;
        return this;
    }

    public DiscoverMovie sortBy(SortBy sortBy) {
        this.sortBy = sortBy;
        return this;
    }

    public DiscoverMovie setWatch_region(String watch_region) {
        this.watch_region = watch_region;
        return this;
    }

    public DiscoverMovie setWith_origin_country(String with_origin_country) {
        this.with_origin_country = with_origin_country;
        return this;
    }

    public DiscoverMovie setWith_original_language(String with_original_language) {
        this.with_original_language = with_original_language;
        return this;
    }

    public DiscoverMovie onYear(Integer year) {
        this.year = year;
        return this;
    }

    List<MediaShort> execute() {
        WebClient client = WebClient.create(urlBase);
        StringBuilder builder = new StringBuilder();
        builder.append("/3/discover/movie?");

        if (language != null) {
            builder.append("language=");
            builder.append(language);
        }

        if (year != null) {
            builder.append("&year=");
            builder.append(year);
        }

        if (page != null) {
            builder.append("&page=");
            builder.append(page);
        }

        if (primary_release_year != null) {
            builder.append("&primary_release_year=");
            builder.append(primary_release_year);
        }

        if (region != null) {
            builder.append("&region=");
            builder.append(region);
        }

        if (release_date_gte != null) {
            builder.append("&release_date.gte=");
            builder.append(release_date_gte);
        }

        if (release_date_lte != null) {
            builder.append("&release_date.lte=");
            builder.append(release_date_lte);
        }

        if (sortBy != null) {
            builder.append("&sort_by=");
            builder.append(sortBy.sort);
        }

        if (watch_region != null) {
            builder.append("&watch_region=");
            builder.append(watch_region);
        }

        if (with_origin_country != null) {
            builder.append("&with_origin_country=");
            builder.append(with_origin_country);
        }

        if (with_original_language != null) {
            builder.append("&with_original_language=");
            builder.append(with_original_language);
        }

        builder.append("&api_key=");
        builder.append(key);

        MediaResponse response = client.get()
                .uri(builder.toString())
                .retrieve()
                .bodyToMono(MediaResponse.class)
                .block();

        if (response == null) {
            return null;
        }

        return response.results;
    }

}
