package com.example.conbd.model.response;

import lombok.Data;

import java.util.List;

@Data
public class MateriasResponse {

    private String nombreMaterias;
    private String nombreProfesor;
    private Integer idUsuario;
    private List<HorarioResponse> horarios;

}

