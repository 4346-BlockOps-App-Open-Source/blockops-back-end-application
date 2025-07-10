package com.example.blockopsbackendaplication.educacionfinanciera.interfaces.controller;

import com.example.blockopsbackendaplication.educacionfinanciera.application.dto.BibliotecaResponse;
import com.example.blockopsbackendaplication.educacionfinanciera.application.service.BibliotecaService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/biblioteca")
@CrossOrigin(origins = "*")
public class BibliotecaController {

    private final BibliotecaService service;

    public BibliotecaController(BibliotecaService service) {
        this.service = service;
    }

    @GetMapping
    public List<BibliotecaResponse> obtenerBiblioteca() {
        return service.obtenerTodo();
    }
}
