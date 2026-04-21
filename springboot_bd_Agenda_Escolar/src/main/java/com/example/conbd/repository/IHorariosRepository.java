package com.example.conbd.repository;

import com.example.conbd.entity.Horarios;
import com.example.conbd.entity.Materia;
import com.example.conbd.entity.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IHorariosRepository extends JpaRepository<Horarios, Integer>{

    List<Horarios> findByMateria(Materia materia);

    List<Horarios> findByMateriaAndUsuarios(Materia materia, Usuarios usuario);

}
