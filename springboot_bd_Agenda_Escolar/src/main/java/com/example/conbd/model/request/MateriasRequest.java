package com.example.conbd.model.request;

import lombok.Data;

import java.util.List;

@Data
public class MateriasRequest {

    private String nombreMaterias;
    private String nameProfesor;
    private Integer idUsuario;
    private List<HorarioRequest> horariosrequest;

}