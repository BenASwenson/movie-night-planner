package com.sparta.movieplanner.justwatch.service;

import com.sparta.movieplanner.justwatch.dto.ProviderDTO;
import com.sparta.movieplanner.justwatch.entity.Show;
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
public class ShowServiceTest {
    @Autowired
    private ShowService showService;

    List<ProviderDTO> providerDTOList;

    @BeforeAll
    public void setup() throws IOException, InterruptedException {
        providerDTOList = showService.findAllShowProvidersByTMDBId(1399);
    }

    @Test
    void testProviderListSize(){
        int listSize = providerDTOList.size();
        Assertions.assertTrue(listSize > 0);
    }
}
