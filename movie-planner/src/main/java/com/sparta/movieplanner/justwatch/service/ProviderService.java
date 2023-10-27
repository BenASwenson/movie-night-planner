package com.sparta.movieplanner.justwatch.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sparta.movieplanner.justwatch.entity.Provider;

import java.io.IOException;
import java.util.List;

public interface ProviderService {

    List<Provider> saveAllProviders() throws IOException, InterruptedException;

    List<Provider> getAllProviders();
}
