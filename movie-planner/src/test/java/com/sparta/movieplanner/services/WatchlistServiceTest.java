package com.sparta.movieplanner.services;

import com.sparta.movieplanner.entities.Type;
import com.sparta.movieplanner.entities.User;
import com.sparta.movieplanner.entities.Watchlist;
import com.sparta.movieplanner.repositories.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@SpringBootTest
public class WatchlistServiceTest {

    @Autowired
    private WatchlistService watchlistService;
    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("Given a user id, returns a list of all records from watchlist database that's assigned to the user")
    public void getAllWatchlistByUserId() {
        Long userId = 2L;

        List<Watchlist> userWatchlist = watchlistService.findAllEntries_ByUserId(userId);
        System.out.println(userWatchlist);
        assertTrue(!userWatchlist.isEmpty());
    }

    @Test
    @DisplayName("creates a new movie watchlist entry in the database")
    public void createNewMovieEntry() {
        int titleId = 181808;
        String title = "Star Wars: The Last Jedi";
        User user = userRepository.findByUsername("test@mail.com").get();

        Watchlist expected = new Watchlist();
        expected.setId(0L);
        expected.setUser(user);
        expected.setTitleId(titleId);
        expected.setTitle(title);
        expected.setType(Type.FILM);

        Watchlist result = watchlistService.createMovieWatchlistEntry(title, titleId, user.getUsername());

        assertEquals(expected.toString(), result.toString());
    }
}
