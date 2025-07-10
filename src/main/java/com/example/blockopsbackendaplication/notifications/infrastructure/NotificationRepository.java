package com.example.blockopsbackendaplication.notifications.infrastructure;

import com.example.blockopsbackendaplication.notifications.domain.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByLeida(boolean leida);
}
