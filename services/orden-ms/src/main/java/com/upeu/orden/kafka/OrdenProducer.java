package com.upeu.orden.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.upeu.orden.dto.OrdenEventoDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrdenProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    @Value("${kafka.topic.orden-eventos:orden-eventos}")
    private String topic;

    public void publicar(OrdenEventoDto evento) {
        try {
            String mensaje = objectMapper.writeValueAsString(evento);
            kafkaTemplate.send(topic, String.valueOf(evento.getOrdenId()), mensaje);
            log.info("Evento publicado en {}: ordenId={}, tipo={}", topic, evento.getOrdenId(), evento.getTipoEvento());
        } catch (Exception e) {
            log.error("Error publicando evento en Kafka: {}", e.getMessage());
        }
    }
}
