package com.example.conbd.service.imp;

import com.example.conbd.entity.Eventos;
import com.example.conbd.model.request.EventoRequest;
import com.example.conbd.model.response.EventoResponse;
import com.example.conbd.repository.IEventosRepository;
import com.example.conbd.service.IEventosService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EventosServiceImp implements IEventosService {

    private final IEventosRepository eventosRepository;

    // ─── Mappers ────────────────────────────────────────────────

    private Eventos toEntity(EventoRequest req) {
        Eventos e = new Eventos();
        e.setUsuarioId(req.getUsuarioId());
        e.setNombre(req.getNombre());
        e.setFechaInicio(req.getFechaInicio());
        e.setFechaFin(req.getFechaFin());
        e.setColor(req.getColor());
        e.setCategoria(req.getCategoria());
        e.setTipo(req.getTipo());
        e.setPrioridad(req.getPrioridad() != null ? req.getPrioridad() : "media");
        e.setRecurrencia(req.getRecurrencia());
        e.setEsImportante(req.getEsImportante() != null ? req.getEsImportante() : false);
        e.setLugar(req.getLugar());
        e.setNotas(req.getNotas());
        return e;
    }

    private EventoResponse toResponse(Eventos e) {
        EventoResponse r = new EventoResponse();
        r.setIdEvento(e.getIdEvento());
        r.setUsuarioId(e.getUsuarioId());
        r.setNombre(e.getNombre());
        r.setFechaInicio(e.getFechaInicio());
        r.setFechaFin(e.getFechaFin());
        r.setColor(e.getColor());
        r.setCategoria(e.getCategoria());
        r.setTipo(e.getTipo());
        r.setPrioridad(e.getPrioridad());
        r.setRecurrencia(e.getRecurrencia());
        r.setEsImportante(e.getEsImportante());
        r.setLugar(e.getLugar());
        r.setNotas(e.getNotas());
        r.setCreatedAt(e.getCreatedAt());
        return r;
    }

    // ─── CRUD ───────────────────────────────────────────────────

    @Override
    public EventoResponse crearEvento(EventoRequest request) {
        Eventos evento = toEntity(request);
        return toResponse(eventosRepository.save(evento));
    }

    @Override
    public EventoResponse actualizarEvento(Integer idEvento, EventoRequest request) {
        Eventos evento = eventosRepository.findById(idEvento)
                .orElseThrow(() -> new RuntimeException("Evento no encontrado con id: " + idEvento));
        evento.setNombre(request.getNombre());
        evento.setFechaInicio(request.getFechaInicio());
        evento.setFechaFin(request.getFechaFin());
        evento.setColor(request.getColor());
        evento.setCategoria(request.getCategoria());
        evento.setTipo(request.getTipo());
        evento.setPrioridad(request.getPrioridad());
        evento.setRecurrencia(request.getRecurrencia());
        evento.setEsImportante(request.getEsImportante());
        evento.setLugar(request.getLugar());
        evento.setNotas(request.getNotas());
        return toResponse(eventosRepository.save(evento));
    }

    @Override
    public void eliminarEvento(Integer idEvento) {
        eventosRepository.deleteById(idEvento);
    }

    @Override
    public EventoResponse obtenerEventoPorId(Integer idEvento) {
        return eventosRepository.findById(idEvento)
                .map(this::toResponse)
                .orElseThrow(() -> new RuntimeException("Evento no encontrado con id: " + idEvento));
    }

    @Override
    public List<EventoResponse> obtenerEventosPorUsuario(Integer usuarioId) {
        return eventosRepository.findByUsuarioId(usuarioId)
                .stream().map(this::toResponse).collect(Collectors.toList());
    }

    @Override
    public List<EventoResponse> obtenerEventosImportantes(Integer usuarioId) {
        return eventosRepository.findByUsuarioIdAndEsImportante(usuarioId, true)
                .stream().map(this::toResponse).collect(Collectors.toList());
    }

    @Override
    public List<EventoResponse> obtenerEventosPorRango(Integer usuarioId,
                                                       LocalDateTime desde,
                                                       LocalDateTime hasta) {
        return eventosRepository
                .findByUsuarioIdAndFechaInicioGreaterThanEqualAndFechaFinLessThanEqual(
                        usuarioId, desde, hasta)
                .stream().map(this::toResponse).collect(Collectors.toList());
    }

    @Override
    public List<EventoResponse> obtenerEventosPorCategoria(Integer usuarioId, String categoria) {
        return eventosRepository.findByUsuarioIdAndCategoria(usuarioId, categoria)
                .stream().map(this::toResponse).collect(Collectors.toList());
    }

    @Override
    public List<EventoResponse> obtenerEventosPorTipo(Integer usuarioId, String tipo) {
        return eventosRepository.findByUsuarioIdAndTipo(usuarioId, tipo)
                .stream().map(this::toResponse).collect(Collectors.toList());
    }
}