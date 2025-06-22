package com.example.blockopsbackendaplication.infrastructure;

import com.example.blockopsbackendaplication.domain.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

    // Metodo para encontrar notificaciones por usuario
    List<Notification> findByUsuario(String usuario);

    // Metodo para encontrar notificaciones leídas o no leídas
    List<Notification> findByLeida(boolean leida);
}
