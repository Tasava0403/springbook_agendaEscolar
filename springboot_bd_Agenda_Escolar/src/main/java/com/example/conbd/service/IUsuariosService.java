package com.example.conbd.service;

import com.example.conbd.model.request.LoginRequest;
import com.example.conbd.model.request.UsuarioRequest;
import com.example.conbd.model.response.UsuariosResponse;

public interface IUsuariosService {
    UsuariosResponse eliminarUsuario(Integer id);
    UsuariosResponse registrarUsuario(UsuarioRequest request);
    UsuariosResponse actualizarUsuario(Integer id, UsuarioRequest request);
    UsuariosResponse loginUsuario(LoginRequest request);
    UsuariosResponse obtenerUsuarioPorId(Integer id);
}
