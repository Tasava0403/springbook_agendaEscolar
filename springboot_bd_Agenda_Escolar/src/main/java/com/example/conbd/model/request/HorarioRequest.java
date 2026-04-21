package com.example.conbd.model.request;

import java.time.LocalTime;

import lombok.Data;

@Data
public class HorarioRequest {

    private String dia_horario;
    private LocalTime horaInicio;
    private LocalTime horaFin;

}
