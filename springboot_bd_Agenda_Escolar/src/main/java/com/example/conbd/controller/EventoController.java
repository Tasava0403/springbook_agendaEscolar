package com.example.conbd.controller;

import com.example.conbd.model.request.EventoRequest;
import com.example.conbd.model.response.EventoResponse;
import com.example.conbd.service.IEventosService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/eventos")
@RequiredArgsConstructor
public class EventoController {

    private final IEventosService eventosService;

    // POST /api/eventos
    @PostMapping
    public ResponseEntity<EventoResponse> crear(@RequestBody EventoRequest request) {
        return ResponseEntity.ok(eventosService.crearEvento(request));
    }

    // PUT /api/eventos/{id}
    @PutMapping("/{id}")
    public ResponseEntity<EventoResponse> actualizar(
            @PathVariable Integer id,
            @RequestBody EventoRequest request) {
        return ResponseEntity.ok(eventosService.actualizarEvento(id, request));
    }

    // DELETE /api/eventos/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        eventosService.eliminarEvento(id);
        return ResponseEntity.noContent().build();
    }

    // GET /api/eventos/{id}
    @GetMapping("/{id}")
    public ResponseEntity<EventoResponse> obtenerPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(eventosService.obtenerEventoPorId(id));
    }

    // GET /api/eventos/usuario/{usuarioId}
    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<EventoResponse>> obtenerPorUsuario(
            @PathVariable Integer usuarioId) {
        return ResponseEntity.ok(eventosService.obtenerEventosPorUsuario(usuarioId));
    }

    // GET /api/eventos/usuario/{usuarioId}/importantes
    @GetMapping("/usuario/{usuarioId}/importantes")
    public ResponseEntity<List<EventoResponse>> obtenerImportantes(
            @PathVariable Integer usuarioId) {
        return ResponseEntity.ok(eventosService.obtenerEventosImportantes(usuarioId));
    }

    // GET /api/eventos/usuario/{usuarioId}/rango?desde=...&hasta=...
    @GetMapping("/usuario/{usuarioId}/rango")
    public ResponseEntity<List<EventoResponse>> obtenerPorRango(
            @PathVariable Integer usuarioId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime desde,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime hasta) {
        return ResponseEntity.ok(eventosService.obtenerEventosPorRango(usuarioId, desde, hasta));
    }

    // GET /api/eventos/usuario/{usuarioId}/categoria?valor=...
    @GetMapping("/usuario/{usuarioId}/categoria")
    public ResponseEntity<List<EventoResponse>> obtenerPorCategoria(
            @PathVariable Integer usuarioId,
            @RequestParam String valor) {
        return ResponseEntity.ok(eventosService.obtenerEventosPorCategoria(usuarioId, valor));
    }

    // GET /api/eventos/usuario/{usuarioId}/tipo?valor=...
    @GetMapping("/usuario/{usuarioId}/tipo")
    public ResponseEntity<List<EventoResponse>> obtenerPorTipo(
            @PathVariable Integer usuarioId,
            @RequestParam String valor) {
        return ResponseEntity.ok(eventosService.obtenerEventosPorTipo(usuarioId, valor));
    }
}
