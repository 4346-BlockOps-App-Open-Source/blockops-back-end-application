package com.example.blockopsbackendaplication.educacionfinanciera.interfaces.controller;

import com.example.blockopsbackendaplication.educacionfinanciera.application.dto.QuizRequest;
import com.example.blockopsbackendaplication.educacionfinanciera.application.dto.QuizResponse;
import com.example.blockopsbackendaplication.educacionfinanciera.application.service.QuizService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quiz")
@Tag(name = "Quiz", description = "API para gestión de quizzes financieros")
public class QuizController {

    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @Operation(summary = "Listar todos los quizzes")
    @GetMapping
    public List<QuizResponse> obtenerTodo() {
        return quizService.obtenerTodo();
    }

    @Operation(summary = "Obtener un quiz por ID")
    @GetMapping("/{id}")
    public QuizResponse obtenerPorId(@PathVariable Long id) {
        return quizService.obtenerPorId(id);
    }

    @Operation(summary = "Crear un nuevo quiz")
    @PostMapping
    public QuizResponse crear(@RequestBody QuizRequest request) {
        return quizService.crear(request);
    }

    @Operation(summary = "Actualizar un quiz existente")
    @PutMapping("/{id}")
    public QuizResponse actualizar(@PathVariable Long id, @RequestBody QuizRequest request) {
        return quizService.actualizar(id, request);
    }

    @Operation(summary = "Eliminar un quiz")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        quizService.eliminar(id);
    }
}
