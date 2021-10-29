package com.github.israelgda.citiesapi.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="cidade")
public class City implements Serializable {

    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private long id;

    @Column(name="uf", nullable = false)
    private Integer uf;

    @Column(name="ibge", nullable = false)
    private Integer ibge;

    @Column(name="lat_lon", nullable = false)
    private Double lat_lon;

    @Column(name="latitude", nullable = false)
    private Double latitude;

    @Column(name="longitude", nullable = false)
    private Double longitude;

    @Column(name="cod_tom", nullable = false)
    private Integer cod_tom;

    //Constructors
    public City() {
    }

    public City(long id, Integer uf, Integer ibge, Double lat_lon, Double latitude, Double longitude, Integer cod_tom) {
        this.id = id;
        this.uf = uf;
        this.ibge = ibge;
        this.lat_lon = lat_lon;
        this.latitude = latitude;
        this.longitude = longitude;
        this.cod_tom = cod_tom;
    }

    //Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getUf() {
        return uf;
    }

    public void setUf(Integer uf) {
        this.uf = uf;
    }

    public Integer getIbge() {
        return ibge;
    }

    public void setIbge(Integer ibge) {
        this.ibge = ibge;
    }

    public Double getLat_lon() {
        return lat_lon;
    }

    public void setLat_lon(Double lat_lon) {
        this.lat_lon = lat_lon;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Integer getCod_tom() {
        return cod_tom;
    }

    public void setCod_tom(Integer cod_tom) {
        this.cod_tom = cod_tom;
    }

    //HashCode and Equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;
        City city = (City) o;
        return id == city.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
