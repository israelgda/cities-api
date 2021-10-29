package com.github.israelgda.citiesapi.resources;

import com.github.israelgda.citiesapi.entities.Country;
import com.github.israelgda.citiesapi.services.CountryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/countries")
public class CountryResource {

    private final CountryService service;

    public CountryResource(CountryService countryService){
        service = countryService;
    }
    @GetMapping(value="/{id}")
    public ResponseEntity<Country> findById(@PathVariable Long id){
        Country country = service.findById(id);
        return ResponseEntity.ok().body(country);
    }
    @GetMapping
    public ResponseEntity<Page<Country>> findAll(Pageable page){
        Page<Country> list = service.findAll(page);
        return ResponseEntity.ok().body(list);
    }
}
