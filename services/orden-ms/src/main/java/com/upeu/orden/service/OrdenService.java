package com.upeu.orden.service;

import com.upeu.orden.dto.OrdenEventoDto;
import com.upeu.orden.dto.OrdenRequest;
import com.upeu.orden.entity.Orden;
import com.upeu.orden.kafka.OrdenProducer;
import com.upeu.orden.repository.OrdenRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrdenService {

    private final OrdenRepository repo;
    private final OrdenProducer producer;

    public List<Orden> listarPorUsuario(Long usuarioId) {
        return repo.findByUsuarioId(usuarioId);
    }

    public Orden buscarPorId(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Orden no encontrada: " + id));
    }

    public Orden crear(OrdenRequest req) {
        Orden orden = repo.save(Orden.builder()
                .usuarioId(req.getUsuarioId())
                .total(req.getTotal())
                .build());

        // Publicar evento en Kafka
        OrdenEventoDto evento = OrdenEventoDto.builder()
                .tipoEvento("orden.creada")
                .ordenId(orden.getId())
                .total(orden.getTotal().doubleValue())
                .estado(orden.getEstado())
                .origen("orden-ms")
                .timestamp(System.currentTimeMillis())
                .build();

        producer.publicar(evento);

        log.info("Orden creada y evento publicado: ordenId={}", orden.getId());
        return orden;
    }
}
