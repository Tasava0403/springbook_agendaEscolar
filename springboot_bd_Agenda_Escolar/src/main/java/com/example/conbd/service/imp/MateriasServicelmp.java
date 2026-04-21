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

    @Override
    public MateriaResponseRequest actualizarMateria(Integer id, MateriasRequest request) {

        // 1. Buscar la materia existente
        Materia materia = iMateriasRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Materia no encontrada con id: " + id));

        // 2. Buscar el usuario si se quiere cambiar
        Usuarios usuarios = iUsuarioRepository
                .findById(request.getIdUsuario())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // 3. Actualizar los campos
        materia.setNombre_materia(request.getNombreMaterias());
        materia.setProfesor(request.getNameProfesor());
        materia.setUsuarios(usuarios);

        // 4. Guardar los cambios
        Materia materiaActualizada = iMateriasRepository.save(materia);

        // 5. Construir respuesta
        MateriaResponseRequest response = new MateriaResponseRequest();
        response.setNombreMaterias(materiaActualizada.getNombre_materia());
        response.setNombreProfesor(materiaActualizada.getProfesor());
        response.setIdUsuario(materiaActualizada.getUsuarios().getId_usuario());

        return response;
    }
}
