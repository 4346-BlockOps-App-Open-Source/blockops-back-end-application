package com.example.blockopsbackendaplication.educacionfinanciera.infrastructure.repository;


import com.example.blockopsbackendaplication.educacionfinanciera.domain.model.Biblioteca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BibliotecaRepository extends JpaRepository<Biblioteca, Long> {
}

