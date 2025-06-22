package com.example.blockopsbackendaplication.educacionfinanciera.application.service;

import com.example.blockopsbackendaplication.educacionfinanciera.application.dto.QuizRequest;
import com.example.blockopsbackendaplication.educacionfinanciera.application.dto.QuizResponse;
import com.example.blockopsbackendaplication.educacionfinanciera.domain.model.Quiz;
import com.example.blockopsbackendaplication.educacionfinanciera.infrastructure.repository.QuizRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizService {

    private final QuizRepository repository;

    public QuizService(QuizRepository repository) {
        this.repository = repository;
    }

    public List<QuizResponse> obtenerTodo() {
        return repository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public QuizResponse obtenerPorId(Long id) {
        Quiz quiz = repository.findById(id).orElseThrow(() -> new RuntimeException("Quiz no encontrado"));
        return toResponse(quiz);
    }

    public QuizResponse crear(QuizRequest request) {
        Quiz quiz = new Quiz();
        quiz.setPregunta(request.getPregunta());
        quiz.setOpciones(request.getOpciones());
        quiz.setRespuestaCorrecta(request.getRespuestaCorrecta());
        quiz.setExplicacion(request.getExplicacion());
        return toResponse(repository.save(quiz));
    }

    public QuizResponse actualizar(Long id, QuizRequest request) {
        Quiz quiz = repository.findById(id).orElseThrow(() -> new RuntimeException("Quiz no encontrado"));
        quiz.setPregunta(request.getPregunta());
        quiz.setOpciones(request.getOpciones());
        quiz.setRespuestaCorrecta(request.getRespuestaCorrecta());
        quiz.setExplicacion(request.getExplicacion());
        return toResponse(repository.save(quiz));
    }

    public void eliminar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Quiz no encontrado");
        }
        repository.deleteById(id);
    }

    private QuizResponse toResponse(Quiz q) {
        return new QuizResponse(
                q.getId(),
                q.getPregunta(),
                q.getOpciones(),
                q.getRespuestaCorrecta(),
                q.getExplicacion()
        );
    }
}
