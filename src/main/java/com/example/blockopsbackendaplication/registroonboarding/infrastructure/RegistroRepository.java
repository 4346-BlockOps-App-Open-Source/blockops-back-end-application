package com.example.blockopsbackendaplication.registroonboarding.infrastructure;

import com.example.blockopsbackendaplication.registroonboarding.domain.model.Registro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroRepository extends JpaRepository<Registro, Long> {
    boolean existsByCorreo(String correo);
}
