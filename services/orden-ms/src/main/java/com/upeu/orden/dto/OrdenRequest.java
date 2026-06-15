package com.upeu.orden.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class OrdenRequest {

    @NotNull
    private Long usuarioId;

    @NotNull
    @DecimalMin("0.0")
    private BigDecimal total;
}
