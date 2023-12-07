package com.example.countryservice;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SmokeTest {

    @Autowired
    private CountryController countryController;

    @Test
    void contextLoads() throws Exception {
        assertThat(countryController).isNotNull();
    }
}
