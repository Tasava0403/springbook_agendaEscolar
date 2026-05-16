package com.example.conbd.model.request;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class EventoRequest {
    private Integer usuarioId;
    private String nombre;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private String color;
    private String categoria;
    private String tipo;
    private String prioridad;
    private String recurrencia;
    private Boolean esImportante;
    private String lugar;
    private String notas;
}