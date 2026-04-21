package com.example.conbd.service.imp;

import com.example.conbd.entity.Horarios;
import com.example.conbd.entity.Materia;
import com.example.conbd.entity.Usuarios;
import com.example.conbd.model.request.HorarioRequest;
import com.example.conbd.model.request.MateriasRequest;
import com.example.conbd.model.response.HorarioResponse;
import com.example.conbd.model.response.MateriasResponse;
import com.example.conbd.repository.IHorariosRepository;
import com.example.conbd.repository.IMateriasRepository;
import com.example.conbd.repository.IUsuarioRepository;
import com.example.conbd.service.IMateriasService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class MateriasServicelmp implements IMateriasService {

    @Autowired
    private IMateriasRepository iMateriasRepository;

    @Autowired
    private IUsuarioRepository iUsuarioRepository;

    @Autowired
    private IHorariosRepository iHorariosRepository;

    @Transactional
    @Override
    public MateriasResponse guardarMaterias(MateriasRequest request) {

        Usuarios usuarios = iUsuarioRepository
                .findById(request.getIdUsuario())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Materia materia = new Materia();
        materia.setNombre_materia(request.getNombreMaterias());
        materia.setProfesor(request.getNameProfesor());
        materia.setUsuario(usuarios);

        Materia materiaSaved = iMateriasRepository.save(materia);

        List<HorarioResponse> horariosResponse = new ArrayList<>();

        for (HorarioRequest h : request.getHorariosrequest()) {

            Horarios horario = new Horarios();
            horario.setMateria(materiaSaved);
            horario.setUsuarios(usuarios);
            horario.setDia_horario(h.getDia_horario());
            horario.setHora_inicio(h.getHoraInicio());
            horario.setHora_fin(h.getHoraFin());

            Horarios saved = iHorariosRepository.save(horario);

            HorarioResponse hr = new HorarioResponse();
            hr.setDiaHorario(saved.getDia_horario());
            hr.setHoraInicio(saved.getHora_inicio());
            hr.setHoraFin(saved.getHora_fin());

            horariosResponse.add(hr);
        }

        MateriasResponse response = new MateriasResponse();
        response.setNombreMaterias(materiaSaved.getNombre_materia());
        response.setNombreProfesor(materiaSaved.getProfesor());
        response.setIdUsuario(materiaSaved.getUsuario().getId_usuario());
        response.setHorarios(horariosResponse);

        return response;
    }

    @Override
    public void eliminarMateria(Integer idMateria, Integer idUsuario) {

        Materia subject = iMateriasRepository.findById(idMateria)
                .orElseThrow(() -> new RuntimeException("Materia no encontrada"));

        Usuarios user = iUsuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        List<Horarios> horarios = iHorariosRepository
                .findByMateriaAndUsuarios(subject, user);

        iHorariosRepository.deleteAll(horarios);

        iMateriasRepository.delete(subject);
    }

    @Override
    public MateriasResponse actualizarMateria(Integer id, MateriasRequest request) {
        Materia subject = iMateriasRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Materia no encontrada"));

        Usuarios usuario = iUsuarioRepository
                .findById(request.getIdUsuario())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        subject.setNombre_materia(request.getNombreMaterias());
        subject.setProfesor(request.getNameProfesor());
        subject.setUsuario(usuario);

        List<Horarios> horarios = iHorariosRepository
                .findByMateria(subject);

        iHorariosRepository.deleteAll(horarios);

        Materia materiaSaved = iMateriasRepository.save(subject);

        List<HorarioResponse> listaResponse = new ArrayList<>();

        for (HorarioRequest h : request.getHorariosrequest()) {
            Horarios horario = new Horarios();
            horario.setDia_horario(h.getDia_horario());
            horario.setHora_inicio(h.getHoraInicio());
            horario.setHora_fin(h.getHoraFin());

            horario.setMateria(materiaSaved);
            horario.setUsuarios(usuario);

            Horarios saved = iHorariosRepository.save(horario);

            HorarioResponse hr = new HorarioResponse();
            hr.setDiaHorario(saved.getDia_horario());
            hr.setHoraInicio(saved.getHora_inicio());
            hr.setHoraFin(saved.getHora_fin());
            listaResponse.add(hr);
        }

        MateriasResponse response = new MateriasResponse();
        response.setNombreMaterias(materiaSaved.getNombre_materia());
        response.setNombreProfesor(materiaSaved.getProfesor());
        response.setHorarios(listaResponse);

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
