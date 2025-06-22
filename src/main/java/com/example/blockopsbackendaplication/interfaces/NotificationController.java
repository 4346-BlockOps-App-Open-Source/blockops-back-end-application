package com.example.blockopsbackendaplication.interfaces;

import com.example.blockopsbackendaplication.application.NotificationService;
import com.example.blockopsbackendaplication.domain.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notificaciones")
public class NotificationController {

    @Autowired
    private NotificationService notificacionesService;

    // Obtener todas las notificaciones
    @GetMapping
    public List<Notification> obtenerTodasLasNotificaciones() {
        return notificacionesService.obtenerTodasLasNotificaciones();
    }

    // Obtener una notificación por ID
    @GetMapping("/{id}")
    public ResponseEntity<Notification> obtenerNotificacionPorId(@PathVariable Long id) {
        Notification notificacion = notificacionesService.obtenerNotificacionPorId(id);
        if (notificacion != null) {
            return ResponseEntity.ok(notificacion);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Crear una nueva notificación
    @PostMapping
    public Notification crearNotificacion(@RequestBody Notification notificacion) {
        return notificacionesService.crearNotificacion(notificacion);
    }

    // Actualizar una notificación existente
    @PutMapping("/{id}")
    public ResponseEntity<Notification> actualizarNotificacion(@PathVariable Long id, @RequestBody Notification notificacionActualizada) {
        Notification notificacion = notificacionesService.actualizarNotificacion(id, notificacionActualizada);
        if (notificacion != null) {
            return ResponseEntity.ok(notificacion);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar una notificación
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarNotificacion(@PathVariable Long id) {
        if (notificacionesService.eliminarNotificacion(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
