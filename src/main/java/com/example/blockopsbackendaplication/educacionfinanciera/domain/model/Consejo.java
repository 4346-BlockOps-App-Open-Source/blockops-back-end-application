package com.example.blockopsbackendaplication.educacionfinanciera.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Consejo {
    @Id
    private Long id;
    private String titulo;
    private String descripcion;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
