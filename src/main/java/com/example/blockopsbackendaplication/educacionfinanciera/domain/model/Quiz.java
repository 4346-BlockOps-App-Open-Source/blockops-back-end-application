package com.example.blockopsbackendaplication.educacionfinanciera.domain.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "quizzes")
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pregunta;

    @ElementCollection
    @CollectionTable(name = "quiz_opciones", joinColumns = @JoinColumn(name = "quiz_id"))
    @Column(name = "opcion")
    private List<String> opciones;

    private String respuestaCorrecta;

    @Column(length = 3000)
    private String explicacion;

    public Quiz() {
    }

    public Long getId() {
        return id;
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

    public void setId(Long id) {
        this.id = id;
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
