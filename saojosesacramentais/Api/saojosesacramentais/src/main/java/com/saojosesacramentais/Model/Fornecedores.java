package com.saojosesacramentais.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "fornecedores")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Fornecedores {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "razao_social", nullable = false, length = 255)
    private String razaoSocial;
    
    @Column(name = "nome_fantasia", length = 255)
    private String nomeFantasia;
    
    @Column(name = "cnpj", nullable = false, unique = true, length = 18)
    private String cnpj;
    
    @Column(name = "inscricao_estadual", length = 20)
    private String inscricaoEstadual;
    
    @Column(name = "inscricao_municipal", length = 20)
    private String inscricaoMunicipal;
    
    @Column(name = "telefone", length = 20)
    private String telefone;
    
    @Column(name = "celular", length = 20)
    private String celular;
    
    @Column(name = "email", length = 255)
    private String email;
    
    @Column(name = "site", length = 255)
    private String site;
}
