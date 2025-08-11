package com.saojosesacramentais.Controller;

import com.saojosesacramentais.Dto.LoginDto;
import com.saojosesacramentais.Dto.LoginResponseDto;
import com.saojosesacramentais.Model.Usuario;
import com.saojosesacramentais.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {
    
    @Autowired
    private UsuarioService usuarioService;
    
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto) {
        try {
            LoginResponseDto response = usuarioService.fazerLogin(loginDto);
            
            if (response != null) {
                Map<String, Object> result = new HashMap<>();
                result.put("success", true);
                result.put("usuario", response);
                result.put("message", "Login realizado com sucesso");
                return ResponseEntity.ok(result);
            } else {
                Map<String, Object> result = new HashMap<>();
                result.put("success", false);
                result.put("message", "E-mail ou senha incorretos");
                return ResponseEntity.badRequest().body(result);
            }
        } catch (Exception e) {
            Map<String, Object> result = new HashMap<>();
            result.put("success", false);
            result.put("message", "Erro interno do servidor: " + e.getMessage());
            return ResponseEntity.internalServerError().body(result);
        }
    }
    
    @PostMapping("/criar-admin")
    public ResponseEntity<?> criarAdmin() {
        try {
            Usuario admin = usuarioService.criarUsuarioAdmin("adm@saojosesacramentais", "abc123@");
            
            Map<String, Object> result = new HashMap<>();
            result.put("success", true);
            result.put("message", "Usuário administrador criado com sucesso");
            result.put("usuario", LoginResponseDto.fromUsuario(admin, null));
            
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            Map<String, Object> result = new HashMap<>();
            result.put("success", false);
            result.put("message", "Erro ao criar usuário admin: " + e.getMessage());
            return ResponseEntity.badRequest().body(result);
        }
    }
    
    @PostMapping("/alterar-senha")
    public ResponseEntity<?> alterarSenha(@RequestBody Map<String, String> request) {
        try {
            String email = request.get("email");
            String senhaAtual = request.get("senhaAtual");
            String novaSenha = request.get("novaSenha");
            
            if (email == null || senhaAtual == null || novaSenha == null) {
                Map<String, Object> result = new HashMap<>();
                result.put("success", false);
                result.put("message", "Todos os campos são obrigatórios");
                return ResponseEntity.badRequest().body(result);
            }
            
            boolean alterado = usuarioService.alterarSenha(email, senhaAtual, novaSenha);
            
            if (alterado) {
                Map<String, Object> result = new HashMap<>();
                result.put("success", true);
                result.put("message", "Senha alterada com sucesso");
                return ResponseEntity.ok(result);
            } else {
                Map<String, Object> result = new HashMap<>();
                result.put("success", false);
                result.put("message", "E-mail ou senha atual incorretos");
                return ResponseEntity.badRequest().body(result);
            }
        } catch (Exception e) {
            Map<String, Object> result = new HashMap<>();
            result.put("success", false);
            result.put("message", "Erro ao alterar senha: " + e.getMessage());
            return ResponseEntity.badRequest().body(result);
        }
    }
    
    @GetMapping("/perfil/{email}")
    public ResponseEntity<?> buscarPerfil(@PathVariable String email) {
        try {
            Usuario usuario = usuarioService.buscarPorEmail(email);
            
            if (usuario != null) {
                Long clienteId = null;
                if (usuario.getTipo() == Usuario.TipoUsuario.CLIENTE) {
                    clienteId = usuarioService.getClienteIdByEmail(usuario.getEmail());
                }
                Map<String, Object> result = new HashMap<>();
                result.put("success", true);
                result.put("usuario", LoginResponseDto.fromUsuario(usuario, clienteId));
                return ResponseEntity.ok(result);
            } else {
                Map<String, Object> result = new HashMap<>();
                result.put("success", false);
                result.put("message", "Usuário não encontrado");
                return ResponseEntity.badRequest().body(result);
            }
        } catch (Exception e) {
            Map<String, Object> result = new HashMap<>();
            result.put("success", false);
            result.put("message", "Erro ao buscar perfil: " + e.getMessage());
            return ResponseEntity.badRequest().body(result);
        }
    }
} 