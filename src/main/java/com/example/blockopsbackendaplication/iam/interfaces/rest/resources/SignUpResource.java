package com.example.blockopsbackendaplication.iam.interfaces.rest.resources;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SignUpResource(
        @NotBlank @Schema(description = "Nombre de usuario (único)", example = "john_doe") String username,
        @NotBlank @Schema(description = "Primer nombre", example = "John") String firstName,
        @NotBlank @Schema(description = "Apellido", example = "Doe") String lastName,
        @NotBlank @Schema(description = "Correo electrónico", example = "john@example.com") String email,
        @NotBlank @Schema(description = "Contraseña de la cuenta", example = "secreto123") String password,
        @NotNull @Schema(description = "Perfil de riesgo (Conservador, Moderado, Agresivo)", example = "Moderado", allowableValues = {"Conservador", "Moderado", "Agresivo"}) String perfilRiesgo,
        @NotNull @Schema(description = "Preferencia de inversión (Cripto, Acciones, Bonos, Forex)", example = "Cripto", allowableValues = {"Cripto", "Acciones", "Bonos", "Forex"}) String preferencias
) {}
