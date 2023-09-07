package com.example.turismoapp3.modelos;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "zona")
public class Zona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;

    @OneToMany(mappedBy = "zona")
    @JsonManagedReference
    private List<Mercancia> mercancia;

    public Zona() {
    }


    public List<Mercancia> getMercancia() {
        return mercancia;
    }

    public void setMercancia(List<Mercancia> mercancia) {
        this.mercancia = mercancia;
    }

    public Zona(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
