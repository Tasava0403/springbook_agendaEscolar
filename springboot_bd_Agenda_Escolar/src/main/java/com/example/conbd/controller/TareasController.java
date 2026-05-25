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

    // =========================
    // GET - MOSTRAR TODAS
    // =========================
    @GetMapping("/obtener/{id}")
    public List<Tareas> mostrarTareas(@PathVariable Integer id){
        return service.mostrarTareas(id);
    }

    // =========================
    // GET POR ID
    // =========================
    @GetMapping("/{id}")
    public Tareas buscarPorId(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }

    // =========================
    // POST - GUARDAR
    // =========================
    @PostMapping
    public Tareas guardarTarea(@RequestBody Tareas tarea) {
        return service.guardarTarea(tarea);
    }

    // =========================
    // PUT - ACTUALIZAR
    // =========================
    @PutMapping("/{id}")
    public Tareas actualizarTarea(@PathVariable Integer id,
                                  @RequestBody Tareas tarea) {

        Tareas tareaExistente = service.buscarPorId(id);

        if (tareaExistente != null) {

            tareaExistente.setIdUsuario(tarea.getIdUsuario());
            tareaExistente.setIdMateria(tarea.getIdMateria());
            tareaExistente.setDescripcion(tarea.getDescripcion());
            tareaExistente.setFecha(tarea.getFecha());
            tareaExistente.setEstado(tarea.getEstado());
            tareaExistente.setNota(tarea.getNota());

            return service.guardarTarea(tareaExistente);
        }

        return null;
    }

    // =========================
    // DELETE
    // =========================
    @DeleteMapping("/{id}")
    public String eliminarTarea(@PathVariable Integer id) {

        service.eliminarTarea(id);

        return "Tarea eliminada correctamente";
    }
}
