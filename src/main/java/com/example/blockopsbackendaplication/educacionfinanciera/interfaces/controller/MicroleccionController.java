package com.example.blockopsbackendaplication.educacionfinanciera.interfaces.controller;

import com.example.blockopsbackendaplication.educacionfinanciera.application.dto.MicroleccionResponse;
import com.example.blockopsbackendaplication.educacionfinanciera.application.service.MicroleccionService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/microlecciones")
@CrossOrigin(origins = "*")
public class MicroleccionController {

    private final MicroleccionService service;

    public MicroleccionController(MicroleccionService service) {
        this.service = service;
    }

    @GetMapping
    public List<MicroleccionResponse> obtenerMicrolecciones() {
        return service.obtenerTodo();
    }
}
