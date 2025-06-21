package com.example.blockopsbackendaplication.registroonboarding.valueobjects;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Correo implements Serializable {

    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "Correo inválido")
    private String valor;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Correo)) return false;
        Correo correo = (Correo) o;
        return Objects.equals(valor, correo.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor);
    }

    @Override
    public String toString() {
        return valor;
    }
}

