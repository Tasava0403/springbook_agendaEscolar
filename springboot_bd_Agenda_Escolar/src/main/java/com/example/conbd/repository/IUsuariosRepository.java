package com.example.conbd.repository;

import com.example.conbd.entity.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuariosRepository  extends JpaRepository<Usuarios, Integer> {
}
