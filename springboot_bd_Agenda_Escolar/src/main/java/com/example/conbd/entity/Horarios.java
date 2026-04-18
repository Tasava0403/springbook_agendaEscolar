package com.example.conbd.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.LocalTime;

import lombok.Data;

@Data
@Entity
@Table(name = "horario")
public class Horarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_horario;

    @Column(name = "dia_horario", nullable = false, length = 10)
    private String dia_horario;

    @Column(name = "hora_inicio", nullable = false)
    private LocalTime hora_inicio;

    @Column(name = "hora_fin", nullable = false)
    private LocalTime hora_fin;

    @ManyToOne
    @JoinColumn(name = "id_materia")
    private Materia materia;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuarios usuarios;
}