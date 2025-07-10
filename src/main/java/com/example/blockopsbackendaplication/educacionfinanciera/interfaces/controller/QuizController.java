package com.example.blockopsbackendaplication.educacionfinanciera.interfaces.controller;

import com.example.blockopsbackendaplication.educacionfinanciera.application.dto.QuizResponse;
import com.example.blockopsbackendaplication.educacionfinanciera.application.service.QuizService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/quizzes")
@CrossOrigin(origins = "*")
public class QuizController {

    private final QuizService service;

    public QuizController(QuizService service) {
        this.service = service;
    }

    @GetMapping
    public List<QuizResponse> obtenerQuizzes() {
        return service.obtenerTodo();
    }
}
