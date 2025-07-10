package com.example.blockopsbackendaplication.registroonboarding.application;

import com.example.blockopsbackendaplication.registroonboarding.domain.Usuario;
import com.example.blockopsbackendaplication.registroonboarding.infrastructure.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public Usuario registrarUsuario(RegistroRequest request) {
        // Aquí podrías validar redundancias, seguridad, hashing, etc.
        Usuario usuario = Usuario.builder()
                .nombre(request.getNombre())
                .correo(request.getCorreo())
                .contraseña(request.getContraseña()) // En producción, haz hash.
                .perfilRiesgo(request.getPerfilRiesgo())
                .preferencia(request.getPreferencia())
                .build();

        return usuarioRepository.save(usuario);
    }
}

