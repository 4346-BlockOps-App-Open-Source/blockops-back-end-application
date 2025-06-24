package com.example.blockopsbackendaplication.educacionfinanciera.interfaces.controller;

import com.example.blockopsbackendaplication.educacionfinanciera.application.dto.ConsejoRequest;
import com.example.blockopsbackendaplication.educacionfinanciera.application.dto.ConsejoResponse;
import com.example.blockopsbackendaplication.educacionfinanciera.application.service.ConsejoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/consejo")
@Tag(name = "Consejo", description = "API para gestión de consejos financieros")
public class ConsejoController {

    private final ConsejoService consejoService;

    public ConsejoController(ConsejoService consejoService) {
        this.consejoService = consejoService;
    }

    @Operation(summary = "Listar todos los consejos")
    @GetMapping
    public List<ConsejoResponse> obtenerTodo() {
        return consejoService.obtenerTodo();
    }

    @Operation(summary = "Obtener un consejo por ID")
    @GetMapping("/{id}")
    public ConsejoResponse obtenerPorId(@PathVariable Long id) {
        return consejoService.obtenerPorId(id);
    }

    @Operation(summary = "Crear un nuevo consejo")
    @PostMapping
    public ConsejoResponse crear(@RequestBody ConsejoRequest request) {
        return consejoService.crear(request);
    }

    @Operation(summary = "Actualizar un consejo existente")
    @PutMapping("/{id}")
    public ConsejoResponse actualizar(@PathVariable Long id, @RequestBody ConsejoRequest request) {
        return consejoService.actualizar(id, request);
    }

    @Operation(summary = "Eliminar un consejo")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        consejoService.eliminar(id);
    }
}
