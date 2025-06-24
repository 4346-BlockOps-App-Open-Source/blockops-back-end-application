package com.example.blockopsbackendaplication.educacionfinanciera.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuizRequest {
    private String texto;
    private List<String> opciones;
    private String correcta;
    private String recomendacion;
    private String imagen;
}
