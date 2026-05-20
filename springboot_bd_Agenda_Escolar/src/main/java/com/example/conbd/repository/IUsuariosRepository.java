package com.example.conbd.repository;

import com.example.conbd.entity.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface IUsuariosRepository extends JpaRepository<Usuarios, Integer> {
    Optional<Usuarios> findByUsuario(String usuario);
    Optional<Usuarios> findByCorreo(String correo);
}
