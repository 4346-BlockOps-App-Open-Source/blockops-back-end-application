package com.example.blockopsbackendaplication.educacionfinanciera.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConsejoResponse {
    private Long id;
    private String titulo;
    private String descripcion;
}
