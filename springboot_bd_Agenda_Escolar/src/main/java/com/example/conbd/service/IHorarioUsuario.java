package com.example.conbd.service;

import com.example.conbd.model.request.MateriasRequest;
import com.example.conbd.model.response.MateriaResponseRequest;
import com.example.conbd.model.response.MateriasResponse;
import com.example.conbd.model.response.UsuarioMateriaResponse;

import java.util.List;

public interface IHorarioUsuario {

    UsuarioMateriaResponse obtenerHorarioPorUsuario(Integer id);

}
