package com.example.blockopsbackendaplication.registroonboarding.application.dto;

import com.example.blockopsbackendaplication.registroonboarding.domain.model.PerfilRiesgoEnum;
import com.example.blockopsbackendaplication.registroonboarding.domain.model.PreferenciaEnum;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
    description = "Objeto de solicitud para registrar un nuevo usuario en el sistema de onboarding"
)
public class RegistroRequest {

    @Schema(
        description = "Nombre completo del usuario",
        example = "Ana Lopez"
    )
    @NotBlank
    private String nombre;

    @Schema(
        description = "Correo electrónico válido",
        example = "ana@example.com"
    )
    @Email
    private String correo;

    @Schema(
        description = "Contraseña del usuario (mínimo 6 caracteres)",
        example = "123456"
    )
    @NotBlank
    @Size(min = 6)
    private String contrasena;

    @Schema(
        description = "Perfil de riesgo elegido por el usuario",
        example = "CONSERVADOR",
        allowableValues = {"AGRESIVO", "CONSERVADOR", "MODERADO"}
    )
    private PerfilRiesgoEnum perfilRiesgo;

    @Schema(
        description = "Preferencia de inversión elegida por el usuario",
        example = "ACCIONES",
        allowableValues = {"ACCIONES", "BONOS", "CRIPTO", "FOREX"}
    )
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
