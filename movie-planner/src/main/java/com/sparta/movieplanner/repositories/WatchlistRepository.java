package com.sparta.movieplanner.repositories;

import com.sparta.movieplanner.entities.Type;
import com.sparta.movieplanner.entities.Watchlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WatchlistRepository extends JpaRepository<Watchlist, Long> {
    List<Watchlist> findAllByUserId(Long userId);
    List<Watchlist> findAllByUser_IdAndType(Long userId, Type mediaType);

}

