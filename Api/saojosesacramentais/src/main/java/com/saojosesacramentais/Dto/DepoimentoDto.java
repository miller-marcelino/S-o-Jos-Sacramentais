package com.saojosesacramentais.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepoimentoDto {
    private Long id;
    private String texto;
    private Long clienteId;
    private String clienteNome;
    private String clienteEmail;
    private String dataCriacao;
    private Boolean visivel;
    private String dataAprovacao;
} 