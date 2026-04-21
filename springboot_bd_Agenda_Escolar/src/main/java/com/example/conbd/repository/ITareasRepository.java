package com.example.conbd.repository;

import com.example.conbd.entity.Tareas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITareasRepository extends JpaRepository<Tareas, Integer> {

}
