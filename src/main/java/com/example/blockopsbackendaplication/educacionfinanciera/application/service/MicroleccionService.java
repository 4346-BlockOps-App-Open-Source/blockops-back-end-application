package com.example.blockopsbackendaplication.educacionfinanciera.application.service;

import com.example.blockopsbackendaplication.educacionfinanciera.application.dto.MicroleccionResponse;
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
                .map(m -> new MicroleccionResponse(m.getId(), m.getTema(), m.getContenido(), m.getNivel().name()))
                .collect(Collectors.toList());
    }
}
