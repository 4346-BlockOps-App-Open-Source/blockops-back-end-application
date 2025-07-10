package com.example.blockopsbackendaplication.registroonboarding.interfaces;

import com.example.blockopsbackendaplication.registroonboarding.application.dto.RegistroRequest;
import com.example.blockopsbackendaplication.registroonboarding.application.dto.UsuarioResponse;
import com.example.blockopsbackendaplication.registroonboarding.application.service.RegistroService;
import com.example.blockopsbackendaplication.registroonboarding.domain.model.Usuario;
import com.example.blockopsbackendaplication.registroonboarding.application.assembler.UsuarioAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="/registroonboarding",produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Tag(name = "Registro Onboarding", description = "API para onboarding de usuarios")
public class RegistroController {

    private final RegistroService registroService;
    private final UsuarioAssembler usuarioAssembler;

    @PostMapping("/registro")
    @Operation(summary = "Registra un nuevo usuario", description = "Crea un usuario indicando nombre, correo, contraseña, perfil de riesgo y preferencia")
    public ResponseEntity<UsuarioResponse> registrar(@Valid @RequestBody RegistroRequest request) {
        Usuario usuarioCreado = registroService.registrarUsuario(request);
        UsuarioResponse response = usuarioAssembler.toResponse(usuarioCreado);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/usuarios")
    @Operation(summary = "Obtiene todos los usuarios registrados o filtra por parámetros", description = "Lista de usuarios registrados para onboarding. Puedes buscar por nombre, correo, perfilRiesgo y preferencia.")
    public ResponseEntity<List<UsuarioResponse>> obtenerUsuarios(
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) String correo,
            @RequestParam(required = false) String perfilRiesgo,
            @RequestParam(required = false) String preferencia) {
        List<Usuario> usuarios = registroService.buscarUsuarios(nombre, correo, perfilRiesgo, preferencia);
        List<UsuarioResponse> response = usuarioAssembler.toResponseList(usuarios);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
