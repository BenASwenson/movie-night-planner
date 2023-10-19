package com.sparta.movieplanner.repositories;

import com.sparta.movieplanner.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserById(long id);

    Optional<User> findByUsername(String username);
}
