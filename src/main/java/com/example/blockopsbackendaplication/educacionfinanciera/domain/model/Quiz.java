package com.example.blockopsbackendaplication.educacionfinanciera.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Quiz {
    @Id
    private Long id;

    private String texto;

    private String opcionesJson; // opciones separadas por '|'

    private String correcta;
    private String recomendacion;
    private String imagen;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getOpcionesJson() {
        return opcionesJson;
    }

    public void setOpcionesJson(String opcionesJson) {
        this.opcionesJson = opcionesJson;
    }

    public String getCorrecta() {
        return correcta;
    }

    public void setCorrecta(String correcta) {
        this.correcta = correcta;
    }

    public String getRecomendacion() {
        return recomendacion;
    }

    public void setRecomendacion(String recomendacion) {
        this.recomendacion = recomendacion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
