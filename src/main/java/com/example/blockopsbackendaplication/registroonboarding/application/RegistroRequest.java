package com.example.blockopsbackendaplication.registroonboarding.application;

import com.example.blockopsbackendaplication.registroonboarding.domain.PerfilRiesgo;
import com.example.blockopsbackendaplication.registroonboarding.domain.Preferencia;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegistroRequest {

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @Email(message = "Correo inválido")
    @NotBlank(message = "El correo es obligatorio")
    private String correo;

    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
    private String contraseña;

    @NotNull(message = "El perfil de riesgo es obligatorio")
    private PerfilRiesgo perfilRiesgo;

    @NotNull(message = "La preferencia es obligatoria")
    private Preferencia preferencia;
}

