package com.example.blockopsbackendaplication.educacionfinanciera.infrastructure.repository;

import com.example.blockopsbackendaplication.educacionfinanciera.domain.model.Microleccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MicroleccionRepository extends JpaRepository<Microleccion, Long> {
}

