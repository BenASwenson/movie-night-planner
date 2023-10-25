package com.sparta.movieplanner.repositories;

import com.sparta.movieplanner.entities.Watchlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WatchlistRepository extends JpaRepository<Watchlist, Long> {
    List<Watchlist> findAllEntries_ByUserId(Long userId);
}

