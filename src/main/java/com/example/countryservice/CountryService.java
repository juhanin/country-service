package com.example.countryservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryService {

    public List<Country> cleanCountriesData(Object[] countries) {
        ObjectMapper objectMapper = new ObjectMapper();

        return Arrays.stream(countries)
                .map(countryObj -> objectMapper.convertValue(countryObj, Country.class))
                .collect(Collectors.toList());
    }

    public Country cleanCountryData(Object[] country) {
        ObjectMapper objectMapper = new ObjectMapper();

        return Arrays.stream(country)
                .map(countryObj -> objectMapper.convertValue(countryObj, Country.class))
                .toList()
                .get(0);
    }
}
