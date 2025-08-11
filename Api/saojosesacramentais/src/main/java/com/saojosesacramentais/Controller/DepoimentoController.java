package com.saojosesacramentais.Controller;

import com.saojosesacramentais.Dto.DepoimentoDto;
import com.saojosesacramentais.Model.Depoimento;
import com.saojosesacramentais.Service.DepoimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/depoimentos")
@CrossOrigin(origins = "*")
public class DepoimentoController {
    
    @Autowired
    private DepoimentoService depoimentoService;
    
    @PostMapping("/criar")
    public ResponseEntity<?> criarDepoimento(@RequestBody DepoimentoDto depoimentoDto) {
        try {
            Depoimento depoimento = depoimentoService.criarDepoimento(depoimentoDto);
            
            Map<String, Object> result = new HashMap<>();
            result.put("success", true);
            result.put("message", "Depoimento criado com sucesso! Aguardando aprovação.");
            result.put("depoimento", depoimento);
            
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            Map<String, Object> result = new HashMap<>();
            result.put("success", false);
            result.put("message", "Erro ao criar depoimento: " + e.getMessage());
            return ResponseEntity.badRequest().body(result);
        }
    }
    
    @GetMapping("/visiveis")
    public ResponseEntity<?> listarDepoimentosVisiveis() {
        try {
            List<DepoimentoDto> depoimentos = depoimentoService.listarDepoimentosVisiveis();
            
            Map<String, Object> result = new HashMap<>();
            result.put("success", true);
            result.put("depoimentos", depoimentos);
            
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            Map<String, Object> result = new HashMap<>();
            result.put("success", false);
            result.put("message", "Erro ao listar depoimentos: " + e.getMessage());
            return ResponseEntity.badRequest().body(result);
        }
    }
    
    @GetMapping("/todos")
    public ResponseEntity<?> listarTodosDepoimentos() {
        try {
            List<DepoimentoDto> depoimentos = depoimentoService.listarTodosDepoimentos();
            
            Map<String, Object> result = new HashMap<>();
            result.put("success", true);
            result.put("depoimentos", depoimentos);
            
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            Map<String, Object> result = new HashMap<>();
            result.put("success", false);
            result.put("message", "Erro ao listar depoimentos: " + e.getMessage());
            return ResponseEntity.badRequest().body(result);
        }
    }
    
    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<?> listarDepoimentosPorCliente(@PathVariable Long clienteId) {
        try {
            List<DepoimentoDto> depoimentos = depoimentoService.listarDepoimentosPorCliente(clienteId);
            
            Map<String, Object> result = new HashMap<>();
            result.put("success", true);
            result.put("depoimentos", depoimentos);
            
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            Map<String, Object> result = new HashMap<>();
            result.put("success", false);
            result.put("message", "Erro ao listar depoimentos: " + e.getMessage());
            return ResponseEntity.badRequest().body(result);
        }
    }
    
    @PutMapping("/{depoimentoId}/visibilidade")
    public ResponseEntity<?> alterarVisibilidade(
            @PathVariable Long depoimentoId,
            @RequestParam Boolean visivel) {
        try {
            Depoimento depoimento = depoimentoService.alterarVisibilidade(depoimentoId, visivel);
            
            Map<String, Object> result = new HashMap<>();
            result.put("success", true);
            result.put("message", visivel ? "Depoimento aprovado com sucesso!" : "Depoimento ocultado com sucesso!");
            result.put("depoimento", depoimento);
            
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            Map<String, Object> result = new HashMap<>();
            result.put("success", false);
            result.put("message", "Erro ao alterar visibilidade: " + e.getMessage());
            return ResponseEntity.badRequest().body(result);
        }
    }
    
    @DeleteMapping("/{depoimentoId}")
    public ResponseEntity<?> deletarDepoimento(@PathVariable Long depoimentoId) {
        try {
            depoimentoService.deletarDepoimento(depoimentoId);
            
            Map<String, Object> result = new HashMap<>();
            result.put("success", true);
            result.put("message", "Depoimento deletado com sucesso!");
            
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            Map<String, Object> result = new HashMap<>();
            result.put("success", false);
            result.put("message", "Erro ao deletar depoimento: " + e.getMessage());
            return ResponseEntity.badRequest().body(result);
        }
    }
} 