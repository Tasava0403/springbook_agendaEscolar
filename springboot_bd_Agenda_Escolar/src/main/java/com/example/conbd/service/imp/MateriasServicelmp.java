package com.example.conbd.service.imp;

import com.example.conbd.entity.Materia;
import com.example.conbd.entity.Usuarios;
import com.example.conbd.model.request.MateriasRequest;
import com.example.conbd.model.response.MateriaResponseRequest;
import com.example.conbd.repository.IMateriasRepository;
import com.example.conbd.repository.IUsuarioRepository;
import com.example.conbd.service.IMateriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MateriasServicelmp implements IMateriasService {

    @Autowired
    private IMateriasRepository iMateriasRepository;

    @Autowired
    private IUsuarioRepository iUsuarioRepository;

    @Override
    public MateriaResponseRequest guardarMaterias(MateriasRequest request) {
        Usuarios usuarios = iUsuarioRepository
                .findById(request.getIdUsuario())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Materia materia = new Materia();
        materia.setNombre_materia(request.getNombreMaterias());
        materia.setProfesor(request.getNameProfesor());
        materia.setUsuarios(usuarios);

        Materia materiaSaved = iMateriasRepository.save(materia);

        MateriaResponseRequest response = new MateriaResponseRequest();
        response.setNombreMaterias(materiaSaved.getNombre_materia());
        response.setNombreProfesor(materiaSaved.getProfesor());
        response.setIdUsuario(materiaSaved.getUsuarios().getId_usuario());
        return response;
    }
}
