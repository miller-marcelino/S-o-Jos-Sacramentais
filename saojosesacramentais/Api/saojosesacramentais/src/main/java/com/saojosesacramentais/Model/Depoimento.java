package com.saojosesacramentais.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "depoimentos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Depoimento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "texto", nullable = false, columnDefinition = "TEXT")
    private String texto;
    
    @Column(name = "cliente_id", nullable = false)
    private Long clienteId;
    
    @Column(name = "cliente_nome", nullable = false)
    private String clienteNome;
    
    @Column(name = "cliente_email", nullable = false)
    private String clienteEmail;
    
    @Column(name = "data_criacao", nullable = false)
    private LocalDateTime dataCriacao;
    
    @Column(name = "visivel", nullable = false)
    private Boolean visivel = false;
    
    @Column(name = "data_aprovacao")
    private LocalDateTime dataAprovacao;
    
    @PrePersist
    protected void onCreate() {
        dataCriacao = LocalDateTime.now();
    }
} 