package com.upeu.orden.controller;

import com.upeu.orden.dto.OrdenRequest;
import com.upeu.orden.entity.Orden;
import com.upeu.orden.service.OrdenService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/ordenes")
@RequiredArgsConstructor
public class OrdenController {

    private final OrdenService service;

    @GetMapping("/usuario/{usuarioId}")
    public List<Orden> listarPorUsuario(@PathVariable Long usuarioId) {
        return service.listarPorUsuario(usuarioId);
    }

    @GetMapping("/{id}")
    public Orden buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public ResponseEntity<Orden> crear(@Valid @RequestBody OrdenRequest req) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.crear(req));
    }

    @GetMapping("/instancia")
    public Map<String, String> instancia() {
        return Map.of("servicio", "orden-ms", "status", "UP");
    }
}
