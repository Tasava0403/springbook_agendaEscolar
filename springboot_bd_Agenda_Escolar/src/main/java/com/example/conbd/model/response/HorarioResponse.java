package com.example.conbd.model.response;

import lombok.Data;

import java.time.LocalTime;

@Data
public class HorarioResponse {

    private String diaHorario;
    private LocalTime horaInicio;
    private LocalTime horaFin;

}

