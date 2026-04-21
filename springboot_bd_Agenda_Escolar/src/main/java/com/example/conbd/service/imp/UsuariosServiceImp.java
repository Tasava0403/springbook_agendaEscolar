package com.example.conbd.service.imp;

import com.example.conbd.model.response.UsuariosResponse;
import com.example.conbd.repository.IUsuariosRepository;
import com.example.conbd.service.IUsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuariosServiceImp implements IUsuariosService {

    @Autowired
    private IUsuariosRepository usuariosRepository;

    @Override
    public UsuariosResponse eliminarUsuario(Integer id) {
        UsuariosResponse response = new UsuariosResponse();

        if (usuariosRepository.existsById(id)) {
            usuariosRepository.deleteById(id);
            response.setMensaje("Usuario eliminado correctamente");
        } else {
            response.setMensaje("Usuario no encontrado con id: " + id);
        }

        return response;
    }
}
