package com.example.blockopsbackendaplication.educacionfinanciera.application.service;

import com.example.blockopsbackendaplication.educacionfinanciera.application.dto.MicroleccionRequest;
import com.example.blockopsbackendaplication.educacionfinanciera.application.dto.MicroleccionResponse;
import com.example.blockopsbackendaplication.educacionfinanciera.domain.model.Microleccion;
import com.example.blockopsbackendaplication.educacionfinanciera.infrastructure.repository.MicroleccionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MicroleccionService {

    private final MicroleccionRepository repository;

    public MicroleccionService(MicroleccionRepository repository) {
        this.repository = repository;
    }

    public List<MicroleccionResponse> obtenerTodo() {
        return repository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public MicroleccionResponse obtenerPorId(Long id) {
        Microleccion m = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Microlección no encontrada"));
        return toResponse(m);
    }

    public MicroleccionResponse crear(MicroleccionRequest request) {
        Microleccion m = new Microleccion();
        m.setTema(request.getTema());
        m.setDescripcion(request.getDescripcion());
        m.setContenido(request.getContenido());
        return toResponse(repository.save(m));
    }

    public MicroleccionResponse actualizar(Long id, MicroleccionRequest request) {
        Microleccion m = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Microlección no encontrada"));
        m.setTema(request.getTema());
        m.setDescripcion(request.getDescripcion());
        m.setContenido(request.getContenido());
        return toResponse(repository.save(m));
    }

    public void eliminar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Microlección no encontrada");
        }
        repository.deleteById(id);
    }

    private MicroleccionResponse toResponse(Microleccion m) {
        return new MicroleccionResponse(
                m.getId(),
                m.getTema(),
                m.getDescripcion(),
                m.getContenido()
        );
    }
}