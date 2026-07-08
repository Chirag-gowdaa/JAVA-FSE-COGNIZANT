package com.cognizant.springlearn.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@RestController
public class CountryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    @Autowired
    @Qualifier("countryIndia")
    private Country countryIndia;

    @Autowired
    private CountryService countryService;

    public CountryController() {
        LOGGER.info("Inside CountryController constructor");
    }

    @RequestMapping("/country")
    public Country getCountryIndia() {
        LOGGER.info("Returning India country details");
        return countryIndia;
    }

    @GetMapping("/countries")
    public List<Country> getAllCountries() {
        LOGGER.info("Returning all countries");
        return countryService.getAllCountries();
    }

    @GetMapping("/country/{code}")
    public Country getCountry(@PathVariable String code) throws CountryNotFoundException {
        LOGGER.info("Getting country for code: {}", code);
        return countryService.getCountry(code);
    }
}
