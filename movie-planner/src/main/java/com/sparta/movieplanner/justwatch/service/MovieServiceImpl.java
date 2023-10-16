package com.sparta.movieplanner.justwatch.service;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.sparta.movieplanner.justwatch.entity.Movie;
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
    @Override
    public Movie findMovieByTitleAndReleaseYear(String title, int year) throws IOException, InterruptedException {
        // Just watch endpoint (url)
        title = title.replaceAll("\\s", "%20");
        String url = "https://apis.justwatch.com/contentpartner/v2/content/offers/object_type/movie/locale/en_GB?title=" + title + "&" + "release_year=" + year + "&token=ABCdef12";

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
}
