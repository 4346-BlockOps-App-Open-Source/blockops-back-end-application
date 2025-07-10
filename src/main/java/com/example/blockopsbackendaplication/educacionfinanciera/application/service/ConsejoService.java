package com.example.blockopsbackendaplication.educacionfinanciera.application.service;

import com.example.blockopsbackendaplication.educacionfinanciera.application.dto.ConsejoResponse;
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
}
