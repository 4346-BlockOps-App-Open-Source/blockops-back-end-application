package com.example.blockopsbackendaplication.educacionfinanciera.application.dto;

public class MicroleccionResponse {
    private Long id;
    private String tema;
    private String contenido;
    private String nivel;

    public MicroleccionResponse() {
    }

    public MicroleccionResponse(Long id, String tema, String contenido, String nivel) {
        this.id = id;
        this.tema = tema;
        this.contenido = contenido;
        this.nivel = nivel;
    }

    public Long getId() {
        return id;
    }

    public String getTema() {
        return tema;
    }

    public String getContenido() {
        return contenido;
    }

    public String getNivel() {
        return nivel;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
}
