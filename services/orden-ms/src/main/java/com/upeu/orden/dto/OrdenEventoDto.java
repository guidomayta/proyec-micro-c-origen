package com.upeu.orden.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrdenEventoDto {

    private String tipoEvento;
    private Long ordenId;
    private Double total;
    private String estado;
    private String origen;
    private long timestamp;
}
