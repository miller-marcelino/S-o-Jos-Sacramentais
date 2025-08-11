package com.saojosesacramentais.Dto;

import com.saojosesacramentais.Model.Clientes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientesDto {
    
    private Long id;
    private String nomeCompleto;
    private String email;
    private String telefone;
    private String cpfCnpj;
    private String cep;
    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    private String pais;
    private LocalDate dataNascimento;
    private Clientes.Sexo sexo;
    private String senha;
    
    // Construtor para conversão de Entity para DTO
    public ClientesDto(Clientes clientes) {
        this.id = clientes.getId();
        this.nomeCompleto = clientes.getNomeCompleto();
        this.email = clientes.getEmail();
        this.telefone = clientes.getTelefone();
        this.cpfCnpj = clientes.getCpfCnpj();
        this.cep = clientes.getCep();
        this.rua = clientes.getRua();
        this.numero = clientes.getNumero();
        this.bairro = clientes.getBairro();
        this.cidade = clientes.getCidade();
        this.pais = clientes.getPais();
        this.dataNascimento = clientes.getDataNascimento();
        this.sexo = clientes.getSexo();
    }
} 