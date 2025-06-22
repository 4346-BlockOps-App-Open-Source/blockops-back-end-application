package com.example.blockopsbackendaplication.educacionfinanciera.application.dto;

public class MicroleccionRequest {
    private String tema;
    private String descripcion;
    private String contenido;

    public MicroleccionRequest() {
    }

    public MicroleccionRequest(String tema, String descripcion, String contenido) {
        this.tema = tema;
        this.descripcion = descripcion;
        this.contenido = contenido;
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
