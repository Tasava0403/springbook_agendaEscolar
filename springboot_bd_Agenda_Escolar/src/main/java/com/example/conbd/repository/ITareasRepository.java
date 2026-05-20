package com.example.conbd.repository;

import com.example.conbd.entity.Tareas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITareasRepository extends JpaRepository<Tareas, Integer> {
}