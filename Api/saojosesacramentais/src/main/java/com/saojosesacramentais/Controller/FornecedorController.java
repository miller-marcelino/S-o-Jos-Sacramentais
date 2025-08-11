package com.saojosesacramentais.Controller;

import com.saojosesacramentais.Dto.FornecedoresDto;
import com.saojosesacramentais.Model.Fornecedores;
import com.saojosesacramentais.Service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/fornecedores")
@CrossOrigin(origins = "*")
public class FornecedorController {
    
    @Autowired
    private FornecedorService fornecedorService;
    
    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrarFornecedor(@RequestBody FornecedoresDto fornecedorDto) {
        try {
            Fornecedores fornecedor = fornecedorService.cadastrarFornecedor(fornecedorDto);
            
            Map<String, Object> result = new HashMap<>();
            result.put("success", true);
            result.put("message", "Fornecedor cadastrado com sucesso!");
            result.put("fornecedor", fornecedor);
            
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            Map<String, Object> result = new HashMap<>();
            result.put("success", false);
            result.put("message", "Erro ao cadastrar fornecedor: " + e.getMessage());
            return ResponseEntity.badRequest().body(result);
        }
    }
    
    @GetMapping("/listar")
    public ResponseEntity<?> listarFornecedores() {
        try {
            List<Fornecedores> fornecedores = fornecedorService.listarTodosFornecedores();
            
            Map<String, Object> result = new HashMap<>();
            result.put("success", true);
            result.put("fornecedores", fornecedores);
            result.put("total", fornecedores.size());
            
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            Map<String, Object> result = new HashMap<>();
            result.put("success", false);
            result.put("message", "Erro ao listar fornecedores: " + e.getMessage());
            return ResponseEntity.badRequest().body(result);
        }
    }
    
    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarFornecedorPorId(@PathVariable Long id) {
        try {
            Fornecedores fornecedor = fornecedorService.buscarFornecedorPorId(id);
            
            Map<String, Object> result = new HashMap<>();
            result.put("success", true);
            result.put("fornecedor", fornecedor);
            
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            Map<String, Object> result = new HashMap<>();
            result.put("success", false);
            result.put("message", "Erro ao buscar fornecedor: " + e.getMessage());
            return ResponseEntity.badRequest().body(result);
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editarFornecedor(@PathVariable Long id, @RequestBody FornecedoresDto fornecedorDto) {
        try {
            Fornecedores fornecedor = fornecedorService.editarFornecedor(id, fornecedorDto);
            Map<String, Object> result = new HashMap<>();
            result.put("success", true);
            result.put("message", "Fornecedor atualizado com sucesso!");
            result.put("fornecedor", fornecedor);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            Map<String, Object> result = new HashMap<>();
            result.put("success", false);
            result.put("message", "Erro ao editar fornecedor: " + e.getMessage());
            return ResponseEntity.badRequest().body(result);
        }
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<?> excluirFornecedor(@PathVariable Long id) {
        try {
            fornecedorService.excluirFornecedor(id);
            Map<String, Object> result = new HashMap<>();
            result.put("success", true);
            result.put("message", "Fornecedor excluído com sucesso!");
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            Map<String, Object> result = new HashMap<>();
            result.put("success", false);
            result.put("message", "Erro ao excluir fornecedor: " + e.getMessage());
            return ResponseEntity.badRequest().body(result);
        }
    }
} 