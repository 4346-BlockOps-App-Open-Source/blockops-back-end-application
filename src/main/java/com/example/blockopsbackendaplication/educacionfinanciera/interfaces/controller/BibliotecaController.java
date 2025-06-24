package com.example.blockopsbackendaplication.educacionfinanciera.interfaces.controller;

import com.example.blockopsbackendaplication.educacionfinanciera.application.dto.BibliotecaRequest;
import com.example.blockopsbackendaplication.educacionfinanciera.application.dto.BibliotecaResponse;
import com.example.blockopsbackendaplication.educacionfinanciera.application.service.BibliotecaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/biblioteca")
@Tag(name = "Biblioteca", description = "API para recursos educativos financieros")
public class BibliotecaController {

    private final BibliotecaService bibliotecaService;

    public BibliotecaController(BibliotecaService bibliotecaService) {
        this.bibliotecaService = bibliotecaService;
    }

    @Operation(summary = "Listar todos los recursos")
    @GetMapping
    public List<BibliotecaResponse> obtenerTodo() {
        return bibliotecaService.obtenerTodo();
    }

    @Operation(summary = "Obtener recurso por ID")
    @GetMapping("/{id}")
    public BibliotecaResponse obtenerPorId(@PathVariable Long id) {
        return bibliotecaService.obtenerPorId(id);
    }

    @Operation(summary = "Crear nuevo recurso")
    @PostMapping
    public BibliotecaResponse crear(@RequestBody BibliotecaRequest request) {
        return bibliotecaService.crear(request);
    }

    @Operation(summary = "Actualizar recurso existente")
    @PutMapping("/{id}")
    public BibliotecaResponse actualizar(@PathVariable Long id, @RequestBody BibliotecaRequest request) {
        return bibliotecaService.actualizar(id, request);
    }

    @Operation(summary = "Eliminar recurso")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        bibliotecaService.eliminar(id);
    }
}
