package com.example.conbd.controller;

import com.example.conbd.model.request.MateriaRequest;
import com.example.conbd.model.request.MateriasRequest;
import com.example.conbd.model.response.MateriaResponseRequest;
import com.example.conbd.model.response.MateriasResponse;
import com.example.conbd.model.response.UsuarioMateriaResponse;
import com.example.conbd.service.IHorarioUsuario;
import com.example.conbd.service.IMateriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subjects")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class MateriaController {

    @Autowired
    private IMateriasService iMateriasService;

    @Autowired
    private IHorarioUsuario iHorarioUsuario;

    @PostMapping("/materias")
    public ResponseEntity<MateriasResponse> saveSubject(@RequestBody MateriasRequest request) {
        MateriasResponse materia = iMateriasService.guardarMaterias2(request);
        return ResponseEntity.ok(materia);
    }

    @GetMapping("/horariosbyUsuario")
    public ResponseEntity<UsuarioMateriaResponse> getHorariosByUsuario(@RequestParam("id") Integer id) {
        UsuarioMateriaResponse horarios = iHorarioUsuario.obtenerHorarioPorUsuario(id);
        return ResponseEntity.ok(horarios);
    }

    @DeleteMapping("/deleteMateria")
    public ResponseEntity<Void> deleteSubject(@RequestParam("id_usuario") Integer id_usuario, @RequestParam("id_materia")
                                              Integer id_materia) {
        iMateriasService.eliminarMateria(id_materia, id_usuario);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/putMateria")
    public ResponseEntity<MateriasResponse> updateMateria(@RequestParam("id") Integer id, @RequestBody MateriasRequest request) {
        MateriasResponse subject = iMateriasService.actualizarMateria2(id, request);
        return ResponseEntity.ok(subject);
    }

    @PutMapping("/materias/{id}")
    public ResponseEntity<MateriaResponseRequest> updateSubject(@PathVariable Integer id, @RequestBody MateriaRequest request) {

        MateriaResponseRequest materia = iMateriasService.actualizarMateria(id, request);
        return ResponseEntity.ok(materia);
    }
}
