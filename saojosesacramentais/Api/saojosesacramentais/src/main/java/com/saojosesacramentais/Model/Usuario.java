package com.saojosesacramentais.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "email", nullable = false, unique = true, length = 255)
    private String email;
    
    @Column(name = "senha", nullable = false, length = 255)
    private String senha;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false, length = 20)
    private TipoUsuario tipo;
    
    @Column(name = "ativo", nullable = false)
    private Boolean ativo = true;
    
    public enum TipoUsuario {
        ADMIN,
        CLIENTE
    }
} 