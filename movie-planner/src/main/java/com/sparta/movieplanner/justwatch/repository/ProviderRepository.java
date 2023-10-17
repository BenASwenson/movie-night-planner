package com.sparta.movieplanner.justwatch.repository;

import com.sparta.movieplanner.justwatch.entity.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProviderRepository extends JpaRepository<Provider, Integer> {
}
