package com.example.blockopsbackendaplication.educacionfinanciera.interfaces.controller;

import com.example.blockopsbackendaplication.educacionfinanciera.application.dto.MicroleccionRequest;
import com.example.blockopsbackendaplication.educacionfinanciera.application.dto.MicroleccionResponse;
import com.example.blockopsbackendaplication.educacionfinanciera.application.service.MicroleccionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/microleccion")
@Tag(name = "Microlección", description = "API para gestión de microlecciones")
public class MicroleccionController {

    private final MicroleccionService microleccionService;

    public MicroleccionController(MicroleccionService microleccionService) {
        this.microleccionService = microleccionService;
    }

    @Operation(summary = "Listar todas las microlecciones")
    @GetMapping
    public List<MicroleccionResponse> obtenerTodo() {
        return microleccionService.obtenerTodo();
    }

    @Operation(summary = "Obtener una microlección por ID")
    @GetMapping("/{id}")
    public MicroleccionResponse obtenerPorId(@PathVariable Long id) {
        return microleccionService.obtenerPorId(id);
    }

    @Operation(summary = "Crear una nueva microlección")
    @PostMapping
    public MicroleccionResponse crear(@RequestBody MicroleccionRequest request) {
        return microleccionService.crear(request);
    }

    @Operation(summary = "Actualizar una microlección")
    @PutMapping("/{id}")
    public MicroleccionResponse actualizar(@PathVariable Long id, @RequestBody MicroleccionRequest request) {
        return microleccionService.actualizar(id, request);
    }

    @Operation(summary = "Eliminar una microlección")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        microleccionService.eliminar(id);
    }
}