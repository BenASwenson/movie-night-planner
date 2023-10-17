package com.sparta.movieplanner.justwatch.service;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.sparta.movieplanner.justwatch.entity.Movie;
import com.sparta.movieplanner.justwatch.entity.Offers;
import com.sparta.movieplanner.justwatch.entity.Provider;
import com.sparta.movieplanner.justwatch.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    @Value("${api.token}")
    private String token;

    @Autowired
    private ProviderRepository providerRepository;
    @Override
    public Movie findMovieByTitleAndReleaseYear(String title, int year) throws IOException, InterruptedException {

        // Just watch endpoint (url)
        title = title.replaceAll("\\s", "%20");
        String url = "https://apis.justwatch.com/contentpartner/v2/content/offers/object_type/movie/locale/en_GB?title=" + title + "&" + "release_year=" + year + "&token=" + token;

        HttpClient client = HttpClient.newHttpClient();
        // Make the http request
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .header("accept", "application/json")
                .uri(URI.create(url))
                .build();
        // Store the endpoint response
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        ObjectMapper mapper = new ObjectMapper();
        // To bypass the exception ===> com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        mapper.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
        // Map the endpoint response to the Movie entity (object)
        Movie movie = mapper.readValue(response.body(), new TypeReference<Movie>() {});

        return movie;
    }

    @Override
    public Movie findMovieByTMDBId(int id) throws IOException, InterruptedException {

        String url = "https://apis.justwatch.com/contentpartner/v2/content/offers/object_type/movie/id_type/tmdb/locale/en_GB?id=" + id + "&token=" + token;

        HttpClient client = HttpClient.newHttpClient();
        // Make the http request
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .header("accept", "application/json")
                .uri(URI.create(url))
                .build();
        // Store the endpoint response

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        ObjectMapper mapper = new ObjectMapper();
        // To bypass the exception ===> com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        mapper.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
        // Map the endpoint response to the Movie entity (object)
        Movie movie = mapper.readValue(response.body(), new TypeReference<Movie>() {});

        return movie;
    }

    @Override
    public List<Provider> findAllProvidersForAMovieByTMDBId(int id) throws IOException, InterruptedException {

        String url = "https://apis.justwatch.com/contentpartner/v2/content/offers/object_type/movie/id_type/tmdb/locale/en_GB?id=" + id + "&token=" + token;

        HttpClient client = HttpClient.newHttpClient();
        // Make the http request
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .header("accept", "application/json")
                .uri(URI.create(url))
                .build();
        // Store the endpoint response

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        ObjectMapper mapper = new ObjectMapper();
        // To bypass the exception ===> com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        mapper.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
        // Map the endpoint response to the Movie entity (object)
        Movie movie = mapper.readValue(response.body(), new TypeReference<Movie>() {});

        System.out.println(movie);

        List<Provider> providers = new ArrayList<>();
        // e.g. movie with id 2995 gives null providers
        if(movie.getOffers() == null || movie.getOffers().size() == 0) return providers;

        for(int i = 0; i < movie.getOffers().size(); i++){
            Offers offer = movie.getOffers().get(i);
            Provider provider = providerRepository.findById(movie.getOffers().get(i).getProvider_id()).get();
            provider.setMonetization_type(offer.getMonetization_type());
            provider.setPresentation_type(offer.getPresentation_type());
            provider.setRetail_price(offer.getRetail_price());
            provider.setCurrency(offer.getCurrency());
            provider.setProvider_url(offer.getUrls().getRaw_web());

            providers.add(new Provider(provider));
        }
        return providers;
    }
}
