package com.example.blockopsbackendaplication.educacionfinanciera.application.service;

import com.example.blockopsbackendaplication.educacionfinanciera.application.dto.QuizResponse;
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
                .map(q -> new QuizResponse(
                        q.getId(),
                        q.getTexto(),
                        List.of(q.getOpcionesJson().split("\\|")),
                        q.getCorrecta(),
                        q.getRecomendacion(),
                        q.getImagen()
                ))
                .collect(Collectors.toList());
    }
}
