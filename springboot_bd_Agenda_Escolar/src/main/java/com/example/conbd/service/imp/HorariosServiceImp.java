package com.example.conbd.service.imp;

import com.example.conbd.entity.Horarios;
import com.example.conbd.entity.Materia;
import com.example.conbd.entity.Usuarios;
import com.example.conbd.model.request.MateriasRequest;
import com.example.conbd.model.response.HorarioResponse;
import com.example.conbd.model.response.MateriaResponseRequest;
import com.example.conbd.model.response.UsuarioMateriaResponse;
import com.example.conbd.repository.IHorariosRepository;
import com.example.conbd.repository.IMateriasRepository;
import com.example.conbd.repository.IUsuarioRepository;
import com.example.conbd.service.IHorarioUsuario;
import com.example.conbd.service.IMateriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.conbd.model.response.MateriasResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class HorariosServiceImp implements IHorarioUsuario {

    @Autowired
    private IMateriasRepository iMateriasRepository;

    @Autowired
    private IUsuarioRepository iUsuarioRepository;

    @Autowired
    private IHorariosRepository iHorariosRepository;

    @Override
    public UsuarioMateriaResponse obtenerHorarioPorUsuario(Integer id) {

        Usuarios usuarios = iUsuarioRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("usuario no encontrado"));

        List<Materia> materias = iMateriasRepository.findByUsuario(usuarios);

        UsuarioMateriaResponse usuarioMateriaResponse = new UsuarioMateriaResponse();
        List<MateriasResponse> listaMateriasResponse = new ArrayList<>();

        for(Materia s: materias){
            MateriasResponse response = new MateriasResponse();
            response.setIdUsuario(s.getUsuario().getId_usuario());
            response.setNombreMaterias(s.getNombre_materia());
            response.setNombreProfesor(s.getProfesor());
            response.setIdMateria(s.getId_materia());

            List<HorarioResponse> listaHorariosResponses = new ArrayList<>();
            List<Horarios> horariosEntity = iHorariosRepository.findByMateria(s);

            for (Horarios h: horariosEntity){
                HorarioResponse hRes = new HorarioResponse();
                hRes.setDiaHorario(h.getDia_horario());
                hRes.setHoraInicio(h.getHora_inicio());
                hRes.setHoraFin(h.getHora_fin());
                listaHorariosResponses.add(hRes);
            }

            response.setHorarios(listaHorariosResponses);
            listaMateriasResponse.add(response);
        }
        usuarioMateriaResponse.setMateriasResponses(listaMateriasResponse);
        return usuarioMateriaResponse;
    }
}
