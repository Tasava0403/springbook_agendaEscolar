package com.example.conbd.controller;

import com.example.conbd.model.request.MateriasRequest;
import com.example.conbd.model.response.MateriaResponseRequest;
import com.example.conbd.service.IMateriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subjects")
public class MateriaController {

    @Autowired
    private IMateriasService iMateriasService;

    @PostMapping("/materias")
    public ResponseEntity<MateriaResponseRequest> saveSubject(@RequestBody MateriasRequest request) {
        MateriaResponseRequest materia = iMateriasService.guardarMaterias(request);
        return ResponseEntity.ok(materia);
    }

    @PutMapping("/materias/{id}")
    public ResponseEntity<MateriaResponseRequest> updateSubject(
            @PathVariable Integer id,
            @RequestBody MateriasRequest request) {

        MateriaResponseRequest materia = iMateriasService.actualizarMateria(id, request);
        return ResponseEntity.ok(materia);
    }
}
