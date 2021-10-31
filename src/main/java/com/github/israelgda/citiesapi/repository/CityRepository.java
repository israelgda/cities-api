package com.github.israelgda.citiesapi.repository;

import com.github.israelgda.citiesapi.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    @Query(value="select ((select lat_lon from cidade where id = (:city1)) <@> (select lat_lon from cidade where id=(:city2)) as distance", nativeQuery = true)
    Double distanceByPointsInMiles(Long city1, Long city2);

    @Query(value="select earth_distance(\n" +
            "    ll_to_earth(-21.95840072631836,-47.98820114135742), \n" +
            "    ll_to_earth(-22.01740074157715,-47.88600158691406)\n" +
            ") as distance;",nativeQuery = true)
    Double distanceByCubeInMeters(Long city1, Long city2);
}
