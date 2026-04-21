package com.example.conbd.service;

import com.example.conbd.entity.Tareas;
import java.util.List;

public interface ITareasService {

    List<Tareas> listarTareas();

    Tareas buscarPorId(Integer id);

}
