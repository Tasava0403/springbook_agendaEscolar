package com.example.conbd.repository;

import com.example.conbd.entity.Materia;
import com.example.conbd.entity.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IMateriasRepository extends JpaRepository<Materia, Integer> {

    List<Materia> findByUsuario(Usuarios usuarios);
}
