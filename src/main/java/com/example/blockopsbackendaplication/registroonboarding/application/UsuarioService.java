package com.example.blockopsbackendaplication.registroonboarding.application;

import com.example.blockopsbackendaplication.registroonboarding.domain.model.Usuario;
import com.example.blockopsbackendaplication.registroonboarding.domain.model.PerfilRiesgoEnum;
import com.example.blockopsbackendaplication.registroonboarding.domain.model.PreferenciaEnum;
import com.example.blockopsbackendaplication.registroonboarding.application.dto.RegistroRequest;
import com.example.blockopsbackendaplication.registroonboarding.infrastructure.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public Usuario registrarUsuario(RegistroRequest request) {
        // Aquí podrías validar redundancias, seguridad, hashing, etc.
        PerfilRiesgoEnum perfilRiesgo = null;
        PreferenciaEnum preferencia = null;
        if (request.getPerfilRiesgo() != null) {
            perfilRiesgo = PerfilRiesgoEnum.valueOf(request.getPerfilRiesgo().toString());
        }
        if (request.getPreferencia() != null) {
            preferencia = PreferenciaEnum.valueOf(request.getPreferencia().toString());
        }
        Usuario usuario = new Usuario(
                request.getNombre(),
                request.getCorreo(),
                perfilRiesgo,
                preferencia
        );

        return usuarioRepository.save(usuario);
    }
}

