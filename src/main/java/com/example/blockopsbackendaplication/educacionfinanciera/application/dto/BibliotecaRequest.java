package com.example.blockopsbackendaplication.educacionfinanciera.application.dto;

public class BibliotecaRequest {
    private String titulo;
    private String descripcion;
    private String url;

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getUrl() {
        return url;
    }

}
