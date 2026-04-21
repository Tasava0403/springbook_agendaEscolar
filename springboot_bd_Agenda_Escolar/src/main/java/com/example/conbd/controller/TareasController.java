package com.example.conbd.controller;

import com.example.conbd.entity.Tareas;
import com.example.conbd.service.ITareasService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tareas")
public class TareasController {

    @Autowired
    private ITareasService service;

    // GET todas las tareas
    @GetMapping
    public List<Tareas> listarTareas(){
        return service.listarTareas();
    }

    // GET por ID
    @GetMapping("/{id}")
    public Tareas buscarPorId(@PathVariable Integer id){
        return service.buscarPorId(id);
    }

}
