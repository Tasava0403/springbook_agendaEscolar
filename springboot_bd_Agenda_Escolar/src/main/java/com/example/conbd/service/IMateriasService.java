package com.example.conbd.service;

import com.example.conbd.model.request.MateriasRequest;
import com.example.conbd.model.response.MateriaResponseRequest;

public interface IMateriasService {
    MateriaResponseRequest guardarMaterias(MateriasRequest request);
}
