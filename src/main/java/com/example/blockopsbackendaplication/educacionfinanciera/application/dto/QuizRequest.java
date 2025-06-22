package com.example.blockopsbackendaplication.educacionfinanciera.application.dto;

import java.util.List;

public class QuizRequest {
    private String pregunta;
    private List<String> opciones;
    private String respuestaCorrecta;
    private String explicacion;

    public QuizRequest() {
    }

    public QuizRequest(String pregunta, List<String> opciones, String respuestaCorrecta, String explicacion) {
        this.pregunta = pregunta;
        this.opciones = opciones;
        this.respuestaCorrecta = respuestaCorrecta;
        this.explicacion = explicacion;
    }

    public String getPregunta() {
        return pregunta;
    }

    public List<String> getOpciones() {
        return opciones;
    }

    public String getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public String getExplicacion() {
        return explicacion;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public void setOpciones(List<String> opciones) {
        this.opciones = opciones;
    }

    public void setRespuestaCorrecta(String respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public void setExplicacion(String explicacion) {
        this.explicacion = explicacion;
    }
}
