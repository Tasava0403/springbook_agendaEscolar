package com.example.conbd.controller;

import com.example.conbd.model.request.LoginRequest;
import com.example.conbd.model.request.UsuarioRequest;
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

    @PostMapping
    public ResponseEntity<UsuariosResponse> registrarUsuario(@RequestBody UsuarioRequest request) {
        UsuariosResponse response = usuariosService.registrarUsuario(request);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuariosResponse> actualizarUsuario(@PathVariable Integer id, @RequestBody UsuarioRequest request) {
        UsuariosResponse response = usuariosService.actualizarUsuario(id, request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<UsuariosResponse> loginUsuario(@RequestBody LoginRequest request) {
        UsuariosResponse response = usuariosService.loginUsuario(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuariosResponse> obtenerUsuarioPorId(@PathVariable Integer id) {
        UsuariosResponse response = usuariosService.obtenerUsuarioPorId(id);
        return ResponseEntity.ok(response);
    }
}
