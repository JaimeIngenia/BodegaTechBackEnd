package com.example.turismoapp3.modelos;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name="mercancia")
public class Mercancia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String descripcion;
    private LocalDate fechaEntrada;
    private String motivoDevolucion;
    private Double volumen;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fk_zona", referencedColumnName = "id")
    @JsonBackReference
    private Zona zona;

    public Mercancia() {
    }

    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }

    public Mercancia(Integer id, String nombre, String descripcion, LocalDate fechaEntrada, String motivoDevolucion, Double volumen, Zona zona) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaEntrada = fechaEntrada;
        this.motivoDevolucion = motivoDevolucion;
        this.volumen = volumen;
        this.zona = zona;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public String getMotivoDevolucion() {
        return motivoDevolucion;
    }

    public void setMotivoDevolucion(String motivoDevolucion) {
        this.motivoDevolucion = motivoDevolucion;
    }

    public Double getVolumen() {
        return volumen;
    }

    public void setVolumen(Double volumen) {
        this.volumen = volumen;
    }
}
