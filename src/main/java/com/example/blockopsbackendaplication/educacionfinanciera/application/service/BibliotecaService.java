package com.example.blockopsbackendaplication.educacionfinanciera.application.service;

import com.example.blockopsbackendaplication.educacionfinanciera.application.dto.BibliotecaRequest;
import com.example.blockopsbackendaplication.educacionfinanciera.application.dto.BibliotecaResponse;
import com.example.blockopsbackendaplication.educacionfinanciera.domain.model.Biblioteca;
import com.example.blockopsbackendaplication.educacionfinanciera.infrastructure.repository.BibliotecaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BibliotecaService {

    private final BibliotecaRepository repository;

    public BibliotecaService(BibliotecaRepository repository) {
        this.repository = repository;
    }

    public List<BibliotecaResponse> obtenerTodo() {
        return repository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public BibliotecaResponse obtenerPorId(Long id) {
        Biblioteca b = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recurso no encontrado"));
        return toResponse(b);
    }

    public BibliotecaResponse crear(BibliotecaRequest request) {
        Biblioteca b = new Biblioteca();
        b.setTitulo(request.getTitulo());
        b.setDescripcion(request.getDescripcion());
        b.setUrl(request.getUrl());
        return toResponse(repository.save(b));
    }

    public BibliotecaResponse actualizar(Long id, BibliotecaRequest request) {
        Biblioteca b = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recurso no encontrado"));

        b.setTitulo(request.getTitulo());
        b.setDescripcion(request.getDescripcion());
        b.setUrl(request.getUrl());
        return toResponse(repository.save(b));
    }

    public void eliminar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Recurso no encontrado");
        }
        repository.deleteById(id);
    }

    private BibliotecaResponse toResponse(Biblioteca b) {
        return new BibliotecaResponse(b.getId(), b.getTitulo(), b.getDescripcion(), b.getUrl());
    }
}
