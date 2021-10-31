package com.github.israelgda.citiesapi.services;

import com.github.israelgda.citiesapi.entities.City;
import com.github.israelgda.citiesapi.repository.CityDistanceRepository;
import com.github.israelgda.citiesapi.repository.CityRepository;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CityDistanceService {

    private final CityDistanceRepository repository;
    private final CityRepository cityRepository;

    public CityDistanceService(CityDistanceRepository repository, CityRepository cityRepository) {
        this.repository = repository;
        this.cityRepository = cityRepository;
    }

    public Double distanceByPointsInMiles(Long city1, Long city2) {
        Double distance = repository.distanceByPointsInMiles(city1, city2);
        return distance;
    }

    public Double distanceByCubeInMeters(Long city1, Long city2) {
        final List<City> cities = cityRepository.findAllById((Arrays.asList(city1, city2)));

        Point p1 = cities.get(0).getLat_lon();
        Point p2 = cities.get(1).getLat_lon();

        Double distance = repository.distanceByCubeInMeters(p1.getX(), p1.getY(), p2.getX(), p2.getY());
        return distance;
    }
}
