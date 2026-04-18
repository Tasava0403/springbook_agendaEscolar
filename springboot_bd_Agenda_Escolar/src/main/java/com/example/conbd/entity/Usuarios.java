package com.example.conbd.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import lombok.Data;

@Data
@Entity
@Table(name = "usuarios")
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_usuario;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "apellidos", nullable = false, length = 100)
    private String apellidos;

    @Column(name = "correo", nullable = false, length = 100)
    private String correo;

    @Column(name = "usuario", nullable = false, length = 50)
    private String usuario;

    @Column(name = "contraseña", nullable = false, length = 50)
    private String contraseña;

    @Column(name = "semestre", nullable = false)
    private Integer semestre;

    @Column(name = "telefono", nullable = false, length = 15)
    private String telefono;
}