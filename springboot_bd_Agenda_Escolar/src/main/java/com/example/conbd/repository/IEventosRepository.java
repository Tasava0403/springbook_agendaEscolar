package com.example.conbd.repository;

import com.example.conbd.entity.Eventos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface IEventosRepository extends JpaRepository<Eventos, Integer> {

    // Todos los eventos de un usuario
    List<Eventos> findByUsuarioId(Integer usuarioId);

    // Eventos importantes de un usuario
    List<Eventos> findByUsuarioIdAndEsImportante(Integer usuarioId, Boolean esImportante);

    // Eventos por rango de fechas para el calendario semanal/mensual
    List<Eventos> findByUsuarioIdAndFechaInicioGreaterThanEqualAndFechaFinLessThanEqual(
            Integer usuarioId, LocalDateTime desde, LocalDateTime hasta
    );

    // Eventos por categoría
    List<Eventos> findByUsuarioIdAndCategoria(Integer usuarioId, String categoria);

    // Eventos por tipo
    List<Eventos> findByUsuarioIdAndTipo(Integer usuarioId, String tipo);
}