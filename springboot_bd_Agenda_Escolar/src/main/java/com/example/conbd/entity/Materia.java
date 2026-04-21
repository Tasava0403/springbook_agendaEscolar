package com.example.conbd.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import lombok.Data;

@Data
@Entity
@Table(name = "materia")
public class Materia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_materia;

    @Column(name = "nombre_materia", nullable = false, length = 150)
    private String nombre_materia;

    @Column(name = "profesor", nullable = false, length = 150)
    private String profesor;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuarios usuario;
}