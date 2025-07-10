package com.example.blockopsbackendaplication.educacionfinanciera.application.dto;

public class BibliotecaResponse {
    private Long id;
    private String titulo;
    private String descripcion;
    private String url;

    public BibliotecaResponse() {
    }

    public BibliotecaResponse(Long id, String titulo, String descripcion, String url) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.url = url;
    }

    public Long getId() {
        return id;
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
