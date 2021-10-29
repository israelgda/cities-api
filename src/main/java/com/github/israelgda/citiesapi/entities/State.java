package com.github.israelgda.citiesapi.entities;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

@Entity
@Table(name = "estado")
@TypeDefs({
        @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String name;

    @Column(name = "uf")
    private String uf;

    @Column(name = "ibge")
    private Integer ibge;

    @Column(name = "pais")
    private Integer country;

//    @ManyToOne
//    @JoinColumn(name = "pais", referencedColumnName = "id")
//    private Country country;

    @Type(type = "jsonb")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "ddd", columnDefinition = "jsonb")
    private List<Integer> ddd;

    //Constructors
    public State() {
    }

    public State(Long id, String name, String uf, Integer ibge, Integer country, List<Integer> ddd) {
        this.id = id;
        this.name = name;
        this.uf = uf;
        this.ibge = ibge;
        this.country = country;
        this.ddd = ddd;
    }

    //Getters And Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Integer getIbge() {
        return ibge;
    }

    public void setIbge(Integer ibge) {
        this.ibge = ibge;
    }

    public Integer getCountry() {
        return country;
    }

    public void setCountry(Integer country) {
        this.country = country;
    }

    public List<Integer> getDdd() {
        return ddd;
    }

    public void setDdd(List<Integer> ddd) {
        this.ddd = ddd;
    }

    //HashCode and Equals

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof State)) return false;
        State state = (State) o;
        return Objects.equals(id, state.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}