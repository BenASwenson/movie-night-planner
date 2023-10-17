package com.sparta.movieplanner.justwatch.service;

import com.sparta.movieplanner.justwatch.entity.Provider;

import java.io.IOException;
import java.util.List;

public interface ShowService {

    List<Provider> findAllShowProvidersByTMDBId(int id) throws IOException, InterruptedException;
}
