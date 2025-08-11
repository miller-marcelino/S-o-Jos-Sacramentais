package com.saojosesacramentais.Dto;

import com.saojosesacramentais.Model.Fornecedores;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FornecedoresDto {
    
    private Long id;
    private String razaoSocial;
    private String nomeFantasia;
    private String cnpj;
    private String inscricaoEstadual;
    private String inscricaoMunicipal;
    private String telefone;
    private String celular;
    private String email;
    private String site;
    
    // Construtor para conversão de Entity para DTO
    public FornecedoresDto(Fornecedores fornecedores) {
        this.id = fornecedores.getId();
        this.razaoSocial = fornecedores.getRazaoSocial();
        this.nomeFantasia = fornecedores.getNomeFantasia();
        this.cnpj = fornecedores.getCnpj();
        this.inscricaoEstadual = fornecedores.getInscricaoEstadual();
        this.inscricaoMunicipal = fornecedores.getInscricaoMunicipal();
        this.telefone = fornecedores.getTelefone();
        this.celular = fornecedores.getCelular();
        this.email = fornecedores.getEmail();
        this.site = fornecedores.getSite();
    }
} 