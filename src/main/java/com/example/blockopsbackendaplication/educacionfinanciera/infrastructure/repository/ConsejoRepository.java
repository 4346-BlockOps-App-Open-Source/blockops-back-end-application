package com.example.blockopsbackendaplication.educacionfinanciera.infrastructure.repository;

import com.example.blockopsbackendaplication.educacionfinanciera.domain.model.Consejo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsejoRepository extends JpaRepository<Consejo, Long> {
}
