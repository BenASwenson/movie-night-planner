package com.sparta.movieplanner.justwatch.service;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
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
import java.util.List;
@Service
public class ProviderServiceImpl implements ProviderService{
    @Value("${api.token}")
    private String token;
    @Autowired
    private ProviderRepository providerRepository;
    @Override
    public List<Provider> saveAllProviders() throws IOException, InterruptedException {
        String url = "https://apis.justwatch.com/contentpartner/v2/content/providers/all/locale/en_GB?token=" + token;
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .header("accept", "application/json")
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());

        ObjectMapper mapper = new ObjectMapper();
        // To bypass the exception ===> com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        mapper.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));

        List<Provider> providers = mapper.readValue(response.body(), new TypeReference<List<Provider>>() {});

        providerRepository.saveAll(providers);

        return providers;
    }

    @Override
    public List<Provider> getAllProviders() {
        return providerRepository.findAll();
    }
}
