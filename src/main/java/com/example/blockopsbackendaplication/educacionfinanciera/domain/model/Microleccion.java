package com.example.blockopsbackendaplication.educacionfinanciera.domain.model;

import jakarta.persistence.*;

@Entity
@Table(name = "microlecciones")
public class Microleccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tema;
    private String descripcion;

    @Column(length = 5000)
    private String contenido;

    public Microleccion() {
    }

    public Long getId() {
        return id;
    }

    public String getTema() {
        return tema;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getContenido() {
        return contenido;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
}
