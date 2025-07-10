package com.example.blockopsbackendaplication.registroonboarding.application.service;

import com.example.blockopsbackendaplication.registroonboarding.application.dto.RegistroRequest;
import com.example.blockopsbackendaplication.registroonboarding.application.dto.UsuarioResponse;
import com.example.blockopsbackendaplication.registroonboarding.domain.model.Usuario;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import com.example.blockopsbackendaplication.registroonboarding.infrastructure.RegistroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.blockopsbackendaplication.registroonboarding.domain.model.Registro;

@Service
public class RegistroService {

    @Autowired
    private RegistroRepository registroRepository;

    public UsuarioResponse registrarUsuario(RegistroRequest request) {
        Registro registro = new Registro(
            request.getNombre(),
            request.getCorreo(),
            request.getContrasena(),
            request.getPerfilRiesgo(),
            request.getPreferencia()
        );
        Registro guardado = registroRepository.save(registro);

        UsuarioResponse response = new UsuarioResponse();
        response.setNombre(guardado.getNombre());
        response.setCorreo(guardado.getCorreo());
        response.setPerfilRiesgo(guardado.getPerfilRiesgo());
        response.setPreferencia(guardado.getPreferencia());
        return response;
    }

    public List<UsuarioResponse> obtenerUsuarios() {
        List<UsuarioResponse> responses = new ArrayList<>();
        List<Registro> registros = registroRepository.findAll();
        for (Registro registro : registros) {
            UsuarioResponse response = new UsuarioResponse();
            response.setNombre(registro.getNombre());
            response.setCorreo(registro.getCorreo());
            response.setPerfilRiesgo(registro.getPerfilRiesgo());
            response.setPreferencia(registro.getPreferencia());
            responses.add(response);
        }
        return responses;
    }

    public List<UsuarioResponse> buscarUsuarios(String nombre, String correo, String perfilRiesgo, String preferencia) {
        List<UsuarioResponse> responses = new ArrayList<>();
        List<Registro> registros = registroRepository.findAll();
        for (Registro registro : registros) {
            boolean match = (nombre == null || registro.getNombre().equalsIgnoreCase(nombre))
                && (correo == null || registro.getCorreo().equalsIgnoreCase(correo))
                && (perfilRiesgo == null || registro.getPerfilRiesgo().equalsIgnoreCase(perfilRiesgo))
                && (preferencia == null || registro.getPreferencia().equalsIgnoreCase(preferencia));
            if (match) {
                UsuarioResponse response = new UsuarioResponse();
                response.setNombre(registro.getNombre());
                response.setCorreo(registro.getCorreo());
                response.setPerfilRiesgo(registro.getPerfilRiesgo());
                response.setPreferencia(registro.getPreferencia());
                responses.add(response);
            }
        }
        return responses;
    }
}
