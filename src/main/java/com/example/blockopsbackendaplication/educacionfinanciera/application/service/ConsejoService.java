package com.example.blockopsbackendaplication.educacionfinanciera.application.service;

import com.example.blockopsbackendaplication.educacionfinanciera.application.dto.ConsejoRequest;
import com.example.blockopsbackendaplication.educacionfinanciera.application.dto.ConsejoResponse;
import com.example.blockopsbackendaplication.educacionfinanciera.domain.model.Consejo;
import com.example.blockopsbackendaplication.educacionfinanciera.infrastructure.repository.ConsejoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConsejoService {

    private final ConsejoRepository repository;

    public ConsejoService(ConsejoRepository repository) {
        this.repository = repository;
    }

    public List<ConsejoResponse> obtenerTodo() {
        return repository.findAll().stream()
                .map(c -> new ConsejoResponse(c.getId(), c.getTitulo(), c.getDescripcion()))
                .collect(Collectors.toList());
    }

    public ConsejoResponse obtenerPorId(Long id) {
        Consejo c = repository.findById(id).orElseThrow(() -> new RuntimeException("Consejo no encontrado"));
        return new ConsejoResponse(c.getId(), c.getTitulo(), c.getDescripcion());
    }

    public ConsejoResponse crear(ConsejoRequest request) {
        Consejo c = new Consejo();
        c.setTitulo(request.getTitulo());
        c.setDescripcion(request.getDescripcion());
        return toResponse(repository.save(c));
    }

    public ConsejoResponse actualizar(Long id, ConsejoRequest request) {
        Consejo c = repository.findById(id).orElseThrow(() -> new RuntimeException("Consejo no encontrado"));
        c.setTitulo(request.getTitulo());
        c.setDescripcion(request.getDescripcion());
        return toResponse(repository.save(c));
    }

    public void eliminar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Consejo no encontrado");
        }
        repository.deleteById(id);
    }

    private ConsejoResponse toResponse(Consejo c) {
        return new ConsejoResponse(c.getId(), c.getTitulo(), c.getDescripcion());
    }
}
