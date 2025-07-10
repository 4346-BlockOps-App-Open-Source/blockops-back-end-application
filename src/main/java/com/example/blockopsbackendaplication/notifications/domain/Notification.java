package com.example.blockopsbackendaplication.notifications.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "notificaciones")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String contenido;
    private boolean leida;
    private LocalDateTime fechaCreacion;

    @Enumerated(EnumType.STRING)
    private TipoNotificacion tipo;  // Tipo de notificación

    public enum TipoNotificacion {
        CRIPTO,
        ACCIONES,
        BONOS,
        FOREX
    }

    public Notification() {
    }

    public Notification(String contenido, boolean leida, LocalDateTime fechaCreacion,
                        TipoNotificacion tipo) {
        this.contenido = contenido;
        this.leida = leida;
        this.fechaCreacion = fechaCreacion;
        this.tipo = tipo;
    }
}
