package com.github.israelgda.citiesapi.entities;

import com.github.israelgda.citiesapi.utils.PointType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import org.springframework.data.geo.Point;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="cidade")
@TypeDefs(value = {
        @TypeDef(name = "point", typeClass = PointType.class)
})
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

//    @Column(name="lat_lon", nullable = false)
//    private String lat_lon;

    @Type(type = "point")
    @Column(name = "lat_lon", updatable = false, insertable = false)
    private Point lat_lon;

    //Constructors
    public City() {
    }

    public City(long id, Integer uf, Integer ibge, Point lat_lon) {
        this.id = id;
        this.uf = uf;
        this.ibge = ibge;
        this.lat_lon = lat_lon;
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

    public Point getLat_lon() {
        return lat_lon;
    }

    public void setLat_lon(Point lat_lon) {
        this.lat_lon = lat_lon;
    }

//    public String getLat_lon() {
//        return lat_lon;
//    }
//
//    public void setLat_lon(String lat_lon) {
//        this.lat_lon = lat_lon;
//    }

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
