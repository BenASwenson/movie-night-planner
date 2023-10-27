package com.sparta.movieplanner.justwatch.service;

import com.sparta.movieplanner.justwatch.dto.ProviderDTO;
import com.sparta.movieplanner.justwatch.entity.Show;

import java.io.IOException;
import java.util.List;

public interface ShowService {

    Show findShowByTMDBId(int id);
    List<ProviderDTO> findAllShowProvidersByTMDBId(int id) throws IOException, InterruptedException;
}
