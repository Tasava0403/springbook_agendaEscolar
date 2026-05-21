package com.example.conbd.model.request;

import lombok.Data;

@Data
public class UsuarioRequest {
    private String nombre;
    private String apellidos;
    private String correo;
    private String usuario;
    private String contraseña;
    private Integer semestre;
    private String telefono;
}