package com.example.blockopsbackendaplication.registroonboarding.domain.model;

import jakarta.persistence.*;

@Entity
@Table(name = "registros")
public class Registro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String correo;
    private String contrasena;
    private String perfilRiesgo;
    private String preferencia;

    public Registro() {}

    public Registro(String nombre, String correo, String contrasena, String perfilRiesgo, String preferencia) {
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
        this.perfilRiesgo = perfilRiesgo;
        this.preferencia = preferencia;
    }

    // Getters y setters

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getContrasena() {
        return contrasena;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    public String getPerfilRiesgo() {
        return perfilRiesgo;
    }
    public void setPerfilRiesgo(String perfilRiesgo) {
        this.perfilRiesgo = perfilRiesgo;
    }
    public String getPreferencia() {
        return preferencia;
    }
    public void setPreferencia(String preferencia) {
        this.preferencia = preferencia;
    }
}
