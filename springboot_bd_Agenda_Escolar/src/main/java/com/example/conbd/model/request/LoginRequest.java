package com.example.conbd.model.request;

import lombok.Data;

@Data
public class LoginRequest {
    private String usuario;
    private String contraseña;
}