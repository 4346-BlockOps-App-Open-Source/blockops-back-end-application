package com.example.blockopsbackendaplication.registroonboarding.application.service;

import com.example.blockopsbackendaplication.registroonboarding.application.dto.RegistroRequest;
import com.example.blockopsbackendaplication.registroonboarding.domain.PerfilRiesgo;
import com.example.blockopsbackendaplication.registroonboarding.domain.model.Usuario;
import com.example.blockopsbackendaplication.registroonboarding.domain.model.PerfilRiesgoEnum;
import com.example.blockopsbackendaplication.registroonboarding.domain.model.PreferenciaEnum;
import com.example.blockopsbackendaplication.registroonboarding.infrastructure.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RegistroService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario registrarUsuario(RegistroRequest request) {
        PerfilRiesgoEnum perfilRiesgo = request.getPerfilRiesgo();
        PreferenciaEnum preferencia = request.getPreferencia();
        Usuario usuario = new Usuario(
            request.getNombre(),
            request.getCorreo(),
            perfilRiesgo,
            preferencia
        );
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> obtenerUsuarios() {
        return usuarioRepository.findAll();
    }

    public List<Usuario> buscarUsuarios(String nombre, String correo, String perfilRiesgo, String preferencia) {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream().filter(usuario -> {
            boolean match = (nombre == null || usuario.getNombre().equalsIgnoreCase(nombre))
                && (correo == null || usuario.getCorreo().equalsIgnoreCase(correo))
                && (perfilRiesgo == null || usuario.getPerfilRiesgo().name().equalsIgnoreCase(perfilRiesgo))
                && (preferencia == null || usuario.getPreferencia().name().equalsIgnoreCase(preferencia));
            return match;
        }).toList();
    }
}
