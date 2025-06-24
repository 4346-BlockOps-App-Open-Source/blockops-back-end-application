package com.example.blockopsbackendaplication.educacionfinanciera.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MicroleccionRequest {
    private String tema;
    private String descripcion;
    private String contenido;
}
