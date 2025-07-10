package com.example.blockopsbackendaplication.registroonboarding.application.assembler;

import com.example.blockopsbackendaplication.registroonboarding.domain.model.Usuario;
import com.example.blockopsbackendaplication.registroonboarding.application.dto.UsuarioResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UsuarioAssembler {

    public UsuarioResponse toResponse(Usuario usuario) {
        if (usuario == null) return null;
        UsuarioResponse response = new UsuarioResponse();
        response.setNombre(usuario.getNombre());
        response.setCorreo(usuario.getCorreo());
        response.setPerfilRiesgo(usuario.getPerfilRiesgo());
        response.setPreferencia(usuario.getPreferencia());
        return response;
    }

    public List<UsuarioResponse> toResponseList(List<Usuario> usuarios) {
        return usuarios == null ? null :
            usuarios.stream().map(this::toResponse).collect(Collectors.toList());
    }
}
