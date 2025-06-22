package com.example.blockopsbackendaplication.application;

import com.example.blockopsbackendaplication.domain.Notification;
import com.example.blockopsbackendaplication.infrastructure.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificacionRepository;

    public List<Notification> obtenerTodasLasNotificaciones() {
        return notificacionRepository.findAll();
    }

    public Notification obtenerNotificacionPorId(Long id) {
        return notificacionRepository.findById(id).orElse(null);
    }

    public Notification crearNotificacion(Notification notificacion) {
        return notificacionRepository.save(notificacion);
    }

    public Notification actualizarNotificacion(Long id, Notification notificacionActualizada) {
        if (notificacionRepository.existsById(id)) {
            notificacionActualizada.setId(id);
            return notificacionRepository.save(notificacionActualizada);
        }
        return null;
    }

    public boolean eliminarNotificacion(Long id) {
        if (notificacionRepository.existsById(id)) {
            notificacionRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Notification> obtenerNotificacionesPorUsuario(String usuario) {
        return notificacionRepository.findByUsuario(usuario);
    }

    public List<Notification> obtenerNotificacionesLeidas(boolean leida) {
        return notificacionRepository.findByLeida(leida);
    }
}
