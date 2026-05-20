package com.example.conbd.model.response;

import com.example.conbd.entity.Usuarios;
import lombok.Data;

@Data
public class UsuariosResponse {
    private String mensaje;
    private boolean exito;
    private Usuarios usuario;
}
