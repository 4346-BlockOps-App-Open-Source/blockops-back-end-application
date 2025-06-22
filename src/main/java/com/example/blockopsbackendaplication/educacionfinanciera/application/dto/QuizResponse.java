package com.example.blockopsbackendaplication.educacionfinanciera.application.dto;
import java.util.List;

public class QuizResponse {
    private Long id;
    private String texto;
    private List<String> opciones;
    private String correcta;
    private String recomendacion;
    private String imagen;

    public QuizResponse(Long id, String pregunta, List<String> opciones, String respuestaCorrecta, String explicacion) {
    }

    public QuizResponse(Long id, String texto, List<String> opciones, String correcta, String recomendacion, String imagen) {
        this.id = id;
        this.texto = texto;
        this.opciones = opciones;
        this.correcta = correcta;
        this.recomendacion = recomendacion;
        this.imagen = imagen;
    }

    public Long getId() {
        return id;
    }

    public String getTexto() {
        return texto;
    }

    public List<String> getOpciones() {
        return opciones;
    }

    public String getCorrecta() {
        return correcta;
    }

    public String getRecomendacion() {
        return recomendacion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void setOpciones(List<String> opciones) {
        this.opciones = opciones;
    }

    public void setCorrecta(String correcta) {
        this.correcta = correcta;
    }

    public void setRecomendacion(String recomendacion) {
        this.recomendacion = recomendacion;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
