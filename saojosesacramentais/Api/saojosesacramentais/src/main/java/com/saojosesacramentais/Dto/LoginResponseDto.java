package com.saojosesacramentais.Dto;

import com.saojosesacramentais.Model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponseDto {
    private Long id;
    private String email;
    private String tipo;
    private Boolean ativo;
    private Long clienteId;
    
    public static LoginResponseDto fromUsuario(Usuario usuario, Long clienteId) {
        return new LoginResponseDto(
            usuario.getId(),
            usuario.getEmail(),
            usuario.getTipo().name(),
            usuario.getAtivo(),
            clienteId
        );
    }
} 