package com.example.conbd.controller;

import com.example.conbd.model.response.UsuariosResponse;
import com.example.conbd.service.IUsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private IUsuariosService usuariosService;

    @DeleteMapping("/{id}")
    public ResponseEntity<UsuariosResponse> eliminarUsuario(@PathVariable Integer id) {
        UsuariosResponse response = usuariosService.eliminarUsuario(id);
        return ResponseEntity.ok(response);
    }
}