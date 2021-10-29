package com.github.israelgda.citiesapi.repository;

import com.github.israelgda.citiesapi.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
}
