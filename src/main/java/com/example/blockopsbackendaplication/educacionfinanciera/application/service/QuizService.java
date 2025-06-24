package com.example.blockopsbackendaplication.educacionfinanciera.application.service;

import com.example.blockopsbackendaplication.educacionfinanciera.application.dto.QuizRequest;
import com.example.blockopsbackendaplication.educacionfinanciera.application.dto.QuizResponse;
import com.example.blockopsbackendaplication.educacionfinanciera.domain.model.Quiz;
import com.example.blockopsbackendaplication.educacionfinanciera.domain.model.QuizOpcion;
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
        Quiz quiz = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Quiz no encontrado"));
        return toResponse(quiz);
    }

    public QuizResponse crear(QuizRequest request) {
        Quiz quiz = new Quiz();
        quiz.setTexto(request.getTexto());
        quiz.setCorrecta(request.getCorrecta());
        quiz.setRecomendacion(request.getRecomendacion());
        quiz.setImagen(request.getImagen());

        // Crear opciones asociadas
        List<QuizOpcion> opciones = request.getOpciones().stream()
                .map(op -> {
                    QuizOpcion opcion = new QuizOpcion();
                    opcion.setOpcion(op);
                    opcion.setQuiz(quiz); // establecer la relación bidireccional
                    return opcion;
                }).collect(Collectors.toList());

        quiz.setOpciones(opciones);

        return toResponse(repository.save(quiz));
    }

    public QuizResponse actualizar(Long id, QuizRequest request) {
        Quiz quiz = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Quiz no encontrado"));

        quiz.setTexto(request.getTexto());
        quiz.setCorrecta(request.getCorrecta());
        quiz.setRecomendacion(request.getRecomendacion());
        quiz.setImagen(request.getImagen());

        // Limpiar y reemplazar las opciones
        quiz.getOpciones().clear();

        List<QuizOpcion> nuevasOpciones = request.getOpciones().stream()
                .map(op -> {
                    QuizOpcion opcion = new QuizOpcion();
                    opcion.setOpcion(op);
                    opcion.setQuiz(quiz);
                    return opcion;
                }).collect(Collectors.toList());

        quiz.getOpciones().addAll(nuevasOpciones);

        return toResponse(repository.save(quiz));
    }

    public void eliminar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Quiz no encontrado");
        }
        repository.deleteById(id);
    }

    private QuizResponse toResponse(Quiz q) {
        List<String> opciones = q.getOpciones().stream()
                .map(QuizOpcion::getOpcion)
                .collect(Collectors.toList());

        return new QuizResponse(
                q.getId(),
                q.getTexto(),
                opciones,
                q.getCorrecta(),
                q.getRecomendacion(),
                q.getImagen()
        );
    }
}
