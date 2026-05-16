package com.example.conbd.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "eventos")
public class Eventos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_evento")
    private Integer idEvento;

    @Column(name = "usuario_id", nullable = false)
    private Integer usuarioId;

    @Column(name = "nombre", nullable = false, length = 255)
    private String nombre;

    @Column(name = "fecha_inicio", nullable = false)
    private LocalDateTime fechaInicio;

    @Column(name = "fecha_fin", nullable = false)
    private LocalDateTime fechaFin;

    @Column(name = "color", length = 20)
    private String color;

    @Column(name = "categoria", nullable = false, length = 50)
    private String categoria;

    @Column(name = "tipo", nullable = false, length = 50)
    private String tipo;

    @Column(name = "prioridad", nullable = false, length = 10)
    private String prioridad;

    @Column(name = "recurrencia", length = 10)
    private String recurrencia;

    @Column(name = "es_importante", nullable = false)
    private Boolean esImportante;

    @Column(name = "lugar", length = 255)
    private String lugar;

    @Column(name = "notas", columnDefinition = "TEXT")
    private String notas;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}