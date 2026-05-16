package com.example.conbd.service;

import com.example.conbd.model.request.EventoRequest;
import com.example.conbd.model.response.EventoResponse;

import java.time.LocalDateTime;
import java.util.List;

public interface IEventosService {

    EventoResponse crearEvento(EventoRequest request);

    EventoResponse actualizarEvento(Integer idEvento, EventoRequest request);

    void eliminarEvento(Integer idEvento);

    EventoResponse obtenerEventoPorId(Integer idEvento);

    List<EventoResponse> obtenerEventosPorUsuario(Integer usuarioId);

    List<EventoResponse> obtenerEventosImportantes(Integer usuarioId);

    List<EventoResponse> obtenerEventosPorRango(Integer usuarioId,
                                                LocalDateTime desde,
                                                LocalDateTime hasta);

    List<EventoResponse> obtenerEventosPorCategoria(Integer usuarioId, String categoria);

    List<EventoResponse> obtenerEventosPorTipo(Integer usuarioId, String tipo);
}