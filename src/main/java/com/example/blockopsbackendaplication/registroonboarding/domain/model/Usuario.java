package com.example.blockopsbackendaplication.registroonboarding.domain.model;

public class Usuario {
    private String nombre;
    private String correo;
    private PerfilRiesgoEnum perfilRiesgo;
    private PreferenciaEnum preferencia;

    // Constructor
    public Usuario(String nombre, String correo, PerfilRiesgoEnum perfilRiesgo, PreferenciaEnum preferencia) {
        this.nombre = nombre;
        this.correo = correo;
        this.perfilRiesgo = perfilRiesgo;
        this.preferencia = preferencia;
    }

    // Getters and Setters
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
    public PerfilRiesgoEnum getPerfilRiesgo() {
        return perfilRiesgo;
    }
    public void setPerfilRiesgo(PerfilRiesgoEnum perfilRiesgo) {
        this.perfilRiesgo = perfilRiesgo;
    }
    public PreferenciaEnum getPreferencia() {
        return preferencia;
    }
    public void setPreferencia(PreferenciaEnum preferencia) {
        this.preferencia = preferencia;
    }
}
