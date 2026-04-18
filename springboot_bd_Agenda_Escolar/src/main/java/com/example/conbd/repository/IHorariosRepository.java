package com.example.conbd.repository;

import com.example.conbd.entity.Horarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHorariosRepository extends JpaRepository<Horarios, Integer>{
}
