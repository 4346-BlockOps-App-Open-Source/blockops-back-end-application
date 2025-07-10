package com.example.blockopsbackendaplication.registroonboarding.interfaces;

import com.example.blockopsbackendaplication.registroonboarding.application.dto.RegistroRequest;
import com.example.blockopsbackendaplication.registroonboarding.application.dto.UsuarioResponse;
import com.example.blockopsbackendaplication.registroonboarding.application.service.RegistroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registroonboarding")
@RequiredArgsConstructor
@Tag(name = "Registro Onboarding", description = "API para onboarding de usuarios")
public class RegistroController {

    private final RegistroService registroService;

    @PostMapping("/registro")
    @Operation(summary = "Registra un nuevo usuario", description = "Crea un usuario indicando nombre, correo, contraseña, perfil de riesgo y preferencia")
    public ResponseEntity<UsuarioResponse> registrar(@Valid @RequestBody RegistroRequest request) {
        UsuarioResponse usuario = registroService.registrarUsuario(request);
        return new ResponseEntity<>(usuario, HttpStatus.CREATED);
    }

    @GetMapping("/usuarios")
    @Operation(summary = "Obtiene todos los usuarios registrados o filtra por parámetros", description = "Lista de usuarios registrados para onboarding. Puedes buscar por nombre, correo, perfilRiesgo y preferencia.")
    public ResponseEntity<List<UsuarioResponse>> obtenerUsuarios(
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) String correo,
            @RequestParam(required = false) String perfilRiesgo,
            @RequestParam(required = false) String preferencia) {
        List<UsuarioResponse> usuarios = registroService.buscarUsuarios(nombre, correo, perfilRiesgo, preferencia);
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }
}
