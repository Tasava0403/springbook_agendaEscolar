package com.example.conbd.service;

import com.example.conbd.model.request.MateriasRequest;
import com.example.conbd.model.response.MateriaResponseRequest;

public interface IMateriasService {
    MateriasResponse guardarMaterias(MateriasRequest request);

    void eliminarMateria(Integer id_materia, Integer id_usuario);

    MateriasResponse actualizarMateria(Integer id, MateriasRequest request);

    MateriaResponseRequest guardarMaterias(MateriasRequest request);

    MateriaResponseRequest actualizarMateria(Integer id, MateriasRequest request);
}
