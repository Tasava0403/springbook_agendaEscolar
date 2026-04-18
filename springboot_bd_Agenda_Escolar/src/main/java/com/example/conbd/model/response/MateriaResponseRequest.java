package com.example.conbd.model.response;
import lombok.Data;

import java.util.List;

@Data
public class MateriaResponseRequest {

    private String nombreMaterias;
    private String nombreProfesor;
    private Integer idUsuario;
}
