package com.example.blockopsbackendaplication.notifications.interfaces;

import com.example.blockopsbackendaplication.notifications.application.NotificationService;
import com.example.blockopsbackendaplication.notifications.domain.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;

@RestController
@RequestMapping("/api/notificaciones")
@Tag(name = "Notificaciones", description = "Operaciones de gestión de notificaciones")
public class NotificationController {

    @Autowired
    private NotificationService notificacionesService;

    @GetMapping
    @Operation(summary = "Obtener todas las notificaciones", description = "Obtiene una lista de todas las notificaciones registradas")
    public List<Notification> obtenerTodasLasNotificaciones() {
        return notificacionesService.obtenerTodasLasNotificaciones();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener notificación por ID", description = "Obtiene una notificación específica utilizando su identificador único")
    public ResponseEntity<Notification> obtenerNotificacionPorId(@PathVariable Long id) {
        Notification notificacion = notificacionesService.obtenerNotificacionPorId(id);
        if (notificacion != null) {
            return ResponseEntity.ok(notificacion);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @Operation(summary = "Crear nueva notificación", description = "Crea una nueva notificación con la información proporcionada")
    public Notification crearNotificacion(@RequestBody Notification notificacion) {
        return notificacionesService.crearNotificacion(notificacion);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar notificación existente", description = "Actualiza una notificación identificada por su ID con los datos proporcionados")
    public ResponseEntity<Notification> actualizarNotificacion(@PathVariable Long id, @RequestBody Notification notificacionActualizada) {
        Notification notificacion = notificacionesService.actualizarNotificacion(id, notificacionActualizada);
        if (notificacion != null) {
            return ResponseEntity.ok(notificacion);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar notificación", description = "Elimina una notificación existente a partir del ID proporcionado")
    public ResponseEntity<Void> eliminarNotificacion(@PathVariable Long id) {
        if (notificacionesService.eliminarNotificacion(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
