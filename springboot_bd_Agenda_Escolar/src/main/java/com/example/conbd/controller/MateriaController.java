package com.example.conbd.controller;

import com.example.conbd.model.request.MateriasRequest;
import com.example.conbd.model.response.MateriaResponseRequest;
import com.example.conbd.service.IMateriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/horariosbyUsuario")
    public ResponseEntity<UsuarioMateriaResponse> getHorariosByUsuario(@RequestParam("id") Integer id) {
        UsuarioMateriaResponse horarios = IhorarioUsuario.obtenerHorarioPorUsuario(id);
        return ResponseEntity.ok(horarios);
    }

    @DeleteMapping("/deleteMateria")
    public ResponseEntity<Void> deleteSubject(@RequestParam("id_usuario") Integer id_usuario, @RequestParam("id_materia")
                                              Integer id_materia) {
        iMateriasService.eliminarMateria(id_materia, id_usuario);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/putMateria")
    public ResponseEntity<MateriasResponse> updateSubject(@RequestParam("id") Integer id, @RequestBody MateriasRequest request) {
        MateriasResponse subject = iMateriasService.actualizarMateria(id, request);
        return ResponseEntity.ok(subject);
    }

    @PutMapping("/materias/{id}")
    public ResponseEntity<MateriaResponseRequest> updateSubject(
            @PathVariable Integer id,
            @RequestBody MateriasRequest request) {

        MateriaResponseRequest materia = iMateriasService.actualizarMateria(id, request);
        return ResponseEntity.ok(materia);
    }
}
