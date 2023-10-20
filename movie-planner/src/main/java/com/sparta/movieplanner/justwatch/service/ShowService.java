package com.sparta.movieplanner.justwatch.service;

import com.sparta.movieplanner.justwatch.dto.ProviderDTO;

import java.io.IOException;
import java.util.List;

public interface ShowService {

    List<ProviderDTO> findAllShowProvidersByTMDBId(int id) throws IOException, InterruptedException;
}
