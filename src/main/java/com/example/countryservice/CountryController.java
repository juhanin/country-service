package com.example.countryservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
public class CountryController {

    @GetMapping("/countries")
    public List<Object> getCountries() {
        String restCountriesUrl = "https://restcountries.com/v3.1/all";
        RestTemplate restTemplate = new RestTemplate();
        Object[] countries = restTemplate.getForObject(restCountriesUrl, Object[].class);

        if (countries != null) {
            return Arrays.asList(countries);
        }

        return Collections.emptyList();
    }
}
