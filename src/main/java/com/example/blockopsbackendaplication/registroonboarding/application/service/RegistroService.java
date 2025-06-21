package com.example.blockopsbackendaplication.registroonboarding.application.service;

import com.example.blockopsbackendaplication.registroonboarding.application.dto.RegistroRequest;
import com.example.blockopsbackendaplication.registroonboarding.application.dto.UsuarioResponse;
import com.example.blockopsbackendaplication.registroonboarding.domain.model.Usuario;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class RegistroService {

    // Simulación de almacenamiento en memoria
    private List<Usuario> usuarios = new ArrayList<>();

    public UsuarioResponse registrarUsuario(RegistroRequest request) {
        // Crear entidad de dominio a partir del DTO
        Usuario usuario = new Usuario(
            request.getNombre(),
            request.getCorreo(),
            request.getPerfilRiesgo(),
            request.getPreferencia()
        );
        usuarios.add(usuario);

        // Mapear la entidad a DTO de respuesta
        UsuarioResponse response = new UsuarioResponse();
        response.setNombre(usuario.getNombre());
        response.setCorreo(usuario.getCorreo());
        response.setPerfilRiesgo(usuario.getPerfilRiesgo());
        response.setPreferencia(usuario.getPreferencia());
        return response;
    }

    public List<UsuarioResponse> obtenerUsuarios() {
        List<UsuarioResponse> responses = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            UsuarioResponse response = new UsuarioResponse();
            response.setNombre(usuario.getNombre());
            response.setCorreo(usuario.getCorreo());
            response.setPerfilRiesgo(usuario.getPerfilRiesgo());
            response.setPreferencia(usuario.getPreferencia());
            responses.add(response);
        }
        return responses;
    }

    public List<UsuarioResponse> buscarUsuarios(String nombre, String correo, String perfilRiesgo, String preferencia) {
        List<UsuarioResponse> responses = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            boolean match = (nombre == null || usuario.getNombre().equalsIgnoreCase(nombre))
                && (correo == null || usuario.getCorreo().equalsIgnoreCase(correo))
                && (perfilRiesgo == null || usuario.getPerfilRiesgo().name().equalsIgnoreCase(perfilRiesgo))
                && (preferencia == null || usuario.getPreferencia().name().equalsIgnoreCase(preferencia));
            if (match) {
                UsuarioResponse response = new UsuarioResponse();
                response.setNombre(usuario.getNombre());
                response.setCorreo(usuario.getCorreo());
                response.setPerfilRiesgo(usuario.getPerfilRiesgo());
                response.setPreferencia(usuario.getPreferencia());
                responses.add(response);
            }
        }
        return responses;
    }
}
