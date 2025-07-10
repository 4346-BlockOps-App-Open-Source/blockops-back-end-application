package com.example.blockopsbackendaplication.registroonboarding.application.dto;

import com.example.blockopsbackendaplication.registroonboarding.domain.model.PerfilRiesgoEnum;
import com.example.blockopsbackendaplication.registroonboarding.domain.model.PreferenciaEnum;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class RegistroRequest {

    @NotBlank
    private String nombre;

    @Email
    private String correo;

    @NotBlank
    @Size(min = 6)
    private String contrasena;

    private PerfilRiesgoEnum perfilRiesgo;
    private PreferenciaEnum preferencia;

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
    public String getContrasena() {
        return contrasena;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
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
