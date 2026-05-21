package com.example.conbd.service.imp;

import com.example.conbd.entity.Usuarios;
import com.example.conbd.model.request.LoginRequest;
import com.example.conbd.model.request.UsuarioRequest;
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
            response.setExito(true);
            response.setMensaje("Usuario eliminado correctamente");
        } else {
            response.setExito(false);
            response.setMensaje("Usuario no encontrado con id: " + id);
        }

        return response;
    }

    @Override
    public UsuariosResponse registrarUsuario(UsuarioRequest request) {
        UsuariosResponse response = new UsuariosResponse();

        // Validaciones de existencia previa
        if (usuariosRepository.findByUsuario(request.getUsuario()).isPresent()) {
            response.setExito(false);
            response.setMensaje("El nombre de usuario ya está registrado");
            return response;
        }

        if (usuariosRepository.findByCorreo(request.getCorreo()).isPresent()) {
            response.setExito(false);
            response.setMensaje("El correo electrónico ya está registrado");
            return response;
        }

        // Crear la entidad
        Usuarios nuevoUsuario = new Usuarios();
        nuevoUsuario.setNombre(request.getNombre());
        nuevoUsuario.setApellidos(request.getApellidos());
        nuevoUsuario.setCorreo(request.getCorreo());
        nuevoUsuario.setUsuario(request.getUsuario());
        nuevoUsuario.setContraseña(request.getContraseña());
        nuevoUsuario.setSemestre(request.getSemestre());
        nuevoUsuario.setTelefono(request.getTelefono());

        try {
            Usuarios guardado = usuariosRepository.save(nuevoUsuario);
            response.setExito(true);
            response.setMensaje("Usuario registrado correctamente");
            response.setUsuario(guardado);
        } catch (Exception e) {
            response.setExito(false);
            response.setMensaje("Error al guardar el usuario: " + e.getMessage());
        }

        return response;
    }

    @Override
    public UsuariosResponse actualizarUsuario(Integer id, UsuarioRequest request) {
        UsuariosResponse response = new UsuariosResponse();

        Usuarios usuarioExistente = usuariosRepository.findById(id).orElse(null);
        if (usuarioExistente == null) {
            response.setExito(false);
            response.setMensaje("Usuario no encontrado con id: " + id);
            return response;
        }

        // Si se cambia el nombre de usuario, validar que no esté en uso por otra cuenta
        if (request.getUsuario() != null && !request.getUsuario().equals(usuarioExistente.getUsuario())) {
            if (usuariosRepository.findByUsuario(request.getUsuario()).isPresent()) {
                response.setExito(false);
                response.setMensaje("El nombre de usuario ya está en uso");
                return response;
            }
            usuarioExistente.setUsuario(request.getUsuario());
        }

        // Si se cambia el correo, validar que no esté en uso por otra cuenta
        if (request.getCorreo() != null && !request.getCorreo().equals(usuarioExistente.getCorreo())) {
            if (usuariosRepository.findByCorreo(request.getCorreo()).isPresent()) {
                response.setExito(false);
                response.setMensaje("El correo electrónico ya está en uso");
                return response;
            }
            usuarioExistente.setCorreo(request.getCorreo());
        }

        // Actualizar otros campos si vienen presentes
        if (request.getNombre() != null) {
            usuarioExistente.setNombre(request.getNombre());
        }
        if (request.getApellidos() != null) {
            usuarioExistente.setApellidos(request.getApellidos());
        }
        if (request.getContraseña() != null && !request.getContraseña().isEmpty()) {
            usuarioExistente.setContraseña(request.getContraseña());
        }
        if (request.getSemestre() != null) {
            usuarioExistente.setSemestre(request.getSemestre());
        }
        if (request.getTelefono() != null) {
            usuarioExistente.setTelefono(request.getTelefono());
        }

        try {
            Usuarios guardado = usuariosRepository.save(usuarioExistente);
            response.setExito(true);
            response.setMensaje("Perfil de usuario actualizado correctamente");
            response.setUsuario(guardado);
        } catch (Exception e) {
            response.setExito(false);
            response.setMensaje("Error al actualizar el usuario: " + e.getMessage());
        }

        return response;
    }

    @Override
    public UsuariosResponse loginUsuario(LoginRequest request) {
        UsuariosResponse response = new UsuariosResponse();

        Usuarios usuario = usuariosRepository.findByUsuario(request.getUsuario()).orElse(null);
        if (usuario == null) {
            response.setExito(false);
            response.setMensaje("Usuario no encontrado");
            return response;
        }

        if (usuario.getContraseña().equals(request.getContraseña())) {
            response.setExito(true);
            response.setMensaje("Inicio de sesión exitoso");
            response.setUsuario(usuario);
            response.setId_usuario(usuario.getId_usuario());
        } else {
            response.setExito(false);
            response.setMensaje("Contraseña incorrecta");
        }

        return response;
    }

    @Override
    public UsuariosResponse obtenerUsuarioPorId(Integer id) {
        UsuariosResponse response = new UsuariosResponse();

        usuariosRepository.findById(id).ifPresentOrElse(
                usuario -> {
                    response.setExito(true);
                    response.setMensaje("Usuario obtenido correctamente");
                    response.setUsuario(usuario);
                },
                () -> {
                    response.setExito(false);
                    response.setMensaje("Usuario no encontrado con id: " + id);
                }
        );

        return response;
    }
}