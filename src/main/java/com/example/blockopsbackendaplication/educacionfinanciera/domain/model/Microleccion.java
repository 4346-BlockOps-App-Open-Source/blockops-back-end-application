package com.example.blockopsbackendaplication.educacionfinanciera.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "microleccion")
@Getter
@Setter
@NoArgsConstructor
public class Microleccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tema;
    private String descripcion;

    @Column(length = 5000)
    private String contenido;
}
