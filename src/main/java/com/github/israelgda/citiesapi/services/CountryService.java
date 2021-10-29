package com.github.israelgda.citiesapi.services;

import com.github.israelgda.citiesapi.entities.Country;
import com.github.israelgda.citiesapi.repository.CountryRepository;
import com.github.israelgda.citiesapi.services.exceptions.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    private final CountryRepository repository;

    public CountryService(CountryRepository repository) {
        this.repository = repository;
    }

    public Country findById(Long id) {
        Optional<Country> country = repository.findById(id);
        return country.orElseThrow(()-> new ResourceNotFoundException(id));
    }

    public Page<Country> findAll(Pageable page){
        Page<Country> list = repository.findAll(page);
        return list;
    }


}
