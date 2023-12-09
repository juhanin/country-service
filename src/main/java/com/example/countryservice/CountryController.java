package com.example.countryservice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:1234")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/countries")
    public List<Country> getCountries() {
        String restCountriesUrl = "https://restcountries.com/v3.1/all";
        RestTemplate restTemplate = new RestTemplate();
        Object[] countries = restTemplate.getForObject(restCountriesUrl, Object[].class);

        if (countries != null) {
            return countryService.cleanCountriesData(countries);
        }

        return Collections.emptyList();
    }

    @GetMapping("/countries/{name}")
    public Country getCountry(@PathVariable String name) {
        String restCountriesUrl = "https://restcountries.com/v3.1/name/" + name;
        RestTemplate restTemplate = new RestTemplate();
        Object[] country = restTemplate.getForObject(restCountriesUrl, Object[].class);

        if (country != null) {
            return countryService.cleanCountryData(country);
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find country");
    }
}
