package com.github.israelgda.citiesapi.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="pais")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private long id;

    @Column(name="nome", nullable = false, length = 60)
    private String nome;

    @Column(name="nome_pt", nullable = false, length = 60)
    private String nome_pt;

    @Column(name="sigla", nullable = false, length = 2)
    private String sigla;

    @Column(name="bacen", nullable = false)
    private Integer bacen;

    //Constructors

    public Country(){
    }

    public Country(long id, String nome, String nome_pt, String sigla, Integer bacen) {
        this.id = id;
        this.nome = nome;
        this.nome_pt = nome_pt;
        this.sigla = sigla;
        this.bacen = bacen;
    }

    //Getters and Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome_pt() {
        return nome_pt;
    }

    public void setNome_pt(String nome_pt) {
        this.nome_pt = nome_pt;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public Integer getBacen() {
        return bacen;
    }

    public void setBacen(Integer bacen) {
        this.bacen = bacen;
    }

    //HashCode and Equals

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Country)) return false;
        Country country = (Country) o;
        return id == country.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
