package com.github.israelgda.citiesapi.resources;

import com.github.israelgda.citiesapi.entities.City;
import com.github.israelgda.citiesapi.services.CityService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/cities")
public class CityResource {

    private final CityService service;

    public CityResource(CityService service) {
        this.service = service;
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<City> findById(@PathVariable Long id){
        City city = service.findById(id);
        return ResponseEntity.ok().body(city);
    }

    @GetMapping
    public ResponseEntity<Page<City>> findAll(Pageable page){
        Page<City> list = service.findAll(page);
        return ResponseEntity.ok().body(list);
    }
}
