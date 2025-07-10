package com.example.blockopsbackendaplication.educacionfinanciera.domain.model;

import com.example.blockopsbackendaplication.educacionfinanciera.domain.Nivel;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;

@Entity
public class Microleccion {
    @Id
    private Long id;
    private String tema;
    private String contenido;

    @Enumerated(EnumType.STRING)
    private Nivel nivel;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }
}
