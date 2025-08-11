package com.saojosesacramentais.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "clientes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Clientes {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nome_completo", nullable = false, length = 255)
    private String nomeCompleto;
    
    @Column(name = "email", nullable = false, unique = true, length = 255)
    private String email;
    
    @Column(name = "telefone", length = 20)
    private String telefone;
    
    @Column(name = "cpf_cnpj", unique = true, length = 18)
    private String cpfCnpj;
    
    @Column(name = "cep", length = 10)
    private String cep;
    
    @Column(name = "rua", length = 255)
    private String rua;
    
    @Column(name = "numero", length = 10)
    private String numero;
    
    @Column(name = "bairro", length = 100)
    private String bairro;
    
    @Column(name = "cidade", length = 100)
    private String cidade;
    
    @Column(name = "pais", length = 50)
    private String pais;
    
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "sexo", length = 10)
    private Sexo sexo;
    
    public enum Sexo {
        MASCULINO,
        FEMININO
    }
}
