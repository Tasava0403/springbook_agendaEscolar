package com.example.conbd.service.imp;

import com.example.conbd.entity.Tareas;
import com.example.conbd.repository.ITareasRepository;
import com.example.conbd.service.ITareasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareasServiceImp implements ITareasService {

    @Autowired
    private ITareasRepository repository;

    // MOSTRAR TODAS LAS TAREAS
    @Override
    public List<Tareas> mostrarTareas() {
        return repository.findAll();
    }

    // GUARDAR TAREA
    @Override
    public Tareas guardarTarea(Tareas tarea) {
        return repository.save(tarea);
    }

    // BUSCAR POR ID
    @Override
    public Tareas buscarPorId(Integer id) {
        return repository.findById(id).orElse(null);
    }

    // ELIMINAR TAREA
    @Override
    public void eliminarTarea(Integer id) {
        repository.deleteById(id);
    }
}