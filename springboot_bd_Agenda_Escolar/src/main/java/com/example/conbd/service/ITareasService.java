package com.example.conbd.service;

import com.example.conbd.entity.Tareas;

import java.util.List;

public interface ITareasService {

    // MOSTRAR TODAS LAS TAREAS
    List<Tareas> mostrarTareas(Integer id);

    // GUARDAR TAREA
    Tareas guardarTarea(Tareas tarea);

    // BUSCAR POR ID
    Tareas buscarPorId(Integer id);

    // ELIMINAR
    void eliminarTarea(Integer id);
}