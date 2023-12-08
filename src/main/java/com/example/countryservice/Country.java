package com.example.countryservice;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Country {

    private String name;

    private String country_code;
    private String capital;
    private int population;
    private String flag_file_url;

    public Country() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty(value = "country_code")
    public String getCountry_code() {
        return country_code;
    }

    @JsonProperty(value = "cca2")
    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public String getCapital() {
        return capital;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @JsonProperty(value = "flag_file_url")
    public String getFlag_file_url() {
        return flag_file_url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return population == country.population && Objects.equals(name, country.name) && Objects.equals(country_code, country.country_code) && Objects.equals(capital, country.capital) && Objects.equals(flag_file_url, country.flag_file_url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, country_code, capital, population, flag_file_url);
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", countryCode='" + country_code + '\'' +
                ", capital=" + capital +
                ", population=" + population +
                ", flagFileUrl='" + flag_file_url + '\'' +
                '}';
    }

    @JsonProperty("name")
    private void unpackName(Map<String, Object> name) {
        this.name = (String) name.get("common");
    }

    @JsonProperty("capital")
    private void unpackCapital(List<String> capital) {
        this.capital = capital.get(0);
    }

    @JsonProperty("flags")
    private void unpackFlagFileUrl(Map<String, Object> flags) {
        this.flag_file_url = (String) flags.get("png");
    }
}
