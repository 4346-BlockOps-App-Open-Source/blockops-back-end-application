package com.example.blockopsbackendaplication.educacionfinanciera.interfaces.controller;

import com.example.blockopsbackendaplication.educacionfinanciera.application.dto.ConsejoResponse;
import com.example.blockopsbackendaplication.educacionfinanciera.application.service.ConsejoService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/consejos")
@CrossOrigin(origins = "*")
public class ConsejoController {

    private final ConsejoService service;

    public ConsejoController(ConsejoService service) {
        this.service = service;
    }

    @GetMapping
    public List<ConsejoResponse> obtenerConsejos() {
        return service.obtenerTodo();
    }
}

