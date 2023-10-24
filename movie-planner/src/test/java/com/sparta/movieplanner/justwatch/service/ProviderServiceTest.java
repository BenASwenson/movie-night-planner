package com.sparta.movieplanner.justwatch.service;

import com.sparta.movieplanner.justwatch.entity.Provider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ProviderServiceTest {
    @Autowired
    private ProviderService providerService;

    List<Provider> providers;

    @BeforeAll
    public void setup(){
        providers = providerService.getAllProviders();
    }

    @Test
    void testProviderListSize(){
        int listSize = providers.size();
        Assertions.assertTrue(listSize > 0);
    }
    @Test
    void testSaveProviders() throws IOException, InterruptedException {
        Assertions.assertTrue(providerService.saveAllProviders().size() > 0);
    }
}
