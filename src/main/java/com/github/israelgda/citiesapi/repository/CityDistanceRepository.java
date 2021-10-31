package com.github.israelgda.citiesapi.repository;

import com.github.israelgda.citiesapi.entities.CityDistance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CityDistanceRepository extends JpaRepository<CityDistance, Double> {
    @Query(value="select ((select lat_lon from cidade where id = :city1) <@> (select lat_lon from cidade where id= :city2)) as distance", nativeQuery = true)
    Double distanceByPointsInMiles(Long city1, Long city2);

    @Query(value="select earth_distance(ll_to_earth(:lat1,:long1), ll_to_earth(:lat2,:long2)) as distance;",nativeQuery = true)
    Double distanceByCubeInMeters(Double lat1, Double long1, Double lat2, Double long2);
}