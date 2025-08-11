package com.saojosesacramentais.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidosDto {
    private Long id;
    private Long clienteId;
    private Date dataPedido;
    private BigDecimal valorTotal;
    private String status;
    private String observacao;
} 