package com.example.blockopsbackendaplication.educacionfinanciera.application.service;


import com.example.blockopsbackendaplication.educacionfinanciera.application.dto.BibliotecaResponse;
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
                .map(b -> new BibliotecaResponse(b.getId(), b.getTitulo(), b.getDescripcion(), b.getUrl()))
                .collect(Collectors.toList());
    }
}
