package com.example.blockopsbackendaplication.registroonboarding.infrastructure;

import com.example.blockopsbackendaplication.registroonboarding.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    boolean existsByCorreo(String correo);
}

