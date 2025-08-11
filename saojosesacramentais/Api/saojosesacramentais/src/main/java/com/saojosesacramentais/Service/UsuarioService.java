package com.saojosesacramentais.Service;

import com.saojosesacramentais.Dto.LoginDto;
import com.saojosesacramentais.Dto.LoginResponseDto;
import com.saojosesacramentais.Model.Usuario;
import com.saojosesacramentais.Repository.UsuarioRepository;
import com.saojosesacramentais.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private ClienteRepository clienteRepository;
    
    public LoginResponseDto fazerLogin(LoginDto loginDto) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByEmailAndSenha(
            loginDto.getEmail(), 
            loginDto.getSenha()
        );
        
        if (usuarioOpt.isPresent() && usuarioOpt.get().getAtivo()) {
            Usuario usuario = usuarioOpt.get();
            Long clienteId = null;
            if (usuario.getTipo() == Usuario.TipoUsuario.CLIENTE) {
                clienteId = clienteRepository.findByEmail(usuario.getEmail())
                    .map(c -> c.getId())
                    .orElse(null);
            }
            return LoginResponseDto.fromUsuario(usuario, clienteId);
        }
        
        return null;
    }
    
    public Usuario criarUsuario(Usuario usuario) {
        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            throw new RuntimeException("E-mail já cadastrado");
        }
        return usuarioRepository.save(usuario);
    }
    
    public Usuario criarUsuarioAdmin(String email, String senha) {
        Usuario admin = new Usuario();
        admin.setEmail(email);
        admin.setSenha(senha);
        admin.setTipo(Usuario.TipoUsuario.ADMIN);
        admin.setAtivo(true);
        
        return criarUsuario(admin);
    }
    
    public boolean alterarSenha(String email, String senhaAtual, String novaSenha) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByEmailAndSenha(email, senhaAtual);
        
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            usuario.setSenha(novaSenha);
            usuarioRepository.save(usuario);
            return true;
        }
        
        return false;
    }
    
    public Usuario buscarPorEmail(String email) {
        return usuarioRepository.findByEmail(email).orElse(null);
    }
    
    public Long getClienteIdByEmail(String email) {
        return clienteRepository.findByEmail(email)
            .map(c -> c.getId())
            .orElse(null);
    }
} 