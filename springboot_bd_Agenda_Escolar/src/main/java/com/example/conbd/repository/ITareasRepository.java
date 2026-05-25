package com.example.conbd.repository;

import com.example.conbd.entity.Materia;
import com.example.conbd.entity.Tareas;
import com.example.conbd.entity.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITareasRepository extends JpaRepository<Tareas,Integer>{

    List<Tareas> findByIdUsuario(Integer idUsuario);

}