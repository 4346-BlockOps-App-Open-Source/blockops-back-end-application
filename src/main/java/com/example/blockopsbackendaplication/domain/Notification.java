package com.example.blockopsbackendaplication.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "notificaciones")
public class Notification {

    // Getters y Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String contenido;
    private boolean leida;
    private LocalDateTime fechaCreacion;
    private String usuario;  // Identifica al usuario destinatario

    @Enumerated(EnumType.STRING)
    private TipoNotificacion tipo;  // Tipo de notificación

    // Enum para los tipos de notificación
    public enum TipoNotificacion {
        CRIPTO,
        ACCIONES,
        BONOS,
        FOREX
    }

    // Constructor vacío
    public Notification() {
    }

    // Constructor con parámetros
    public Notification(String contenido, boolean leida, LocalDateTime fechaCreacion,
                        String usuario, TipoNotificacion tipo) {
        this.contenido = contenido;
        this.leida = leida;
        this.fechaCreacion = fechaCreacion;
        this.usuario = usuario;
        this.tipo = tipo;
    }

}
