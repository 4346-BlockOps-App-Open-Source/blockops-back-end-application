package com.example.blockopsbackendaplication.educacionfinanciera.application.dto;

public class MicroleccionResponse {
    private Long id;
    private String tema;
    private String descripcion;
    private String contenido;

    public MicroleccionResponse() {
    }

    public MicroleccionResponse(Long id, String tema, String descripcion, String contenido) {
        this.id = id;
        this.tema = tema;
        this.descripcion = descripcion;
        this.contenido = contenido;
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
