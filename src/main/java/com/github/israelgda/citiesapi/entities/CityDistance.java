package com.github.israelgda.citiesapi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CityDistance {

    @Id
    @Column(name= "distance")
    private Double distance;

    public CityDistance() {
    }

    public CityDistance(Double distance) {
        this.distance = distance;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }
}
