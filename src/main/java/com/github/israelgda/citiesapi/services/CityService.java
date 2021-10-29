package com.github.israelgda.citiesapi.services;

import com.github.israelgda.citiesapi.entities.City;
import com.github.israelgda.citiesapi.repository.CityRepository;
import com.github.israelgda.citiesapi.services.exceptions.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CityService {

    private final CityRepository repository;

    public CityService(CityRepository repository) {
        this.repository = repository;
    }

    public City findById(Long id) {
        Optional<City> city = repository.findById(id);
        return city.orElseThrow(()-> new ResourceNotFoundException(id));
    }

    public Page<City> findAll(Pageable page) {
        Page<City> list = repository.findAll(page);
        return list;
    }
}
