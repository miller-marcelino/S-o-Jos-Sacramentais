package com.saojosesacramentais.Controller;

import com.saojosesacramentais.Dto.ProdutoDto;
import com.saojosesacramentais.Model.Produtos;
import com.saojosesacramentais.Service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/produtos")
@CrossOrigin(origins = "*")
public class ProdutoController {
    
    @Autowired
    private ProdutoService produtoService;
    
    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrarProduto(@RequestBody ProdutoDto produtoDto) {
        try {
            Produtos produto = produtoService.criarProduto(produtoDto);
            
            Map<String, Object> result = new HashMap<>();
            result.put("success", true);
            result.put("message", "Produto cadastrado com sucesso");
            result.put("produto", produto);
            
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            Map<String, Object> result = new HashMap<>();
            result.put("success", false);
            result.put("message", "Erro ao cadastrar produto: " + e.getMessage());
            return ResponseEntity.badRequest().body(result);
        }
    }
    
    @GetMapping("/listar")
    public ResponseEntity<?> listarProdutos() {
        try {
            List<Produtos> produtos = produtoService.listarTodosProdutos();
            
            Map<String, Object> result = new HashMap<>();
            result.put("success", true);
            result.put("produtos", produtos);
            result.put("total", produtos.size());
            
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            Map<String, Object> result = new HashMap<>();
            result.put("success", false);
            result.put("message", "Erro ao listar produtos: " + e.getMessage());
            return ResponseEntity.badRequest().body(result);
        }
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<?> atualizarProduto(@PathVariable Long id, @RequestBody ProdutoDto produtoDto) {
        try {
            System.out.println("Recebendo requisição PUT para atualizar produto ID: " + id);
            System.out.println("Dados recebidos: " + produtoDto);
            Produtos produto = produtoService.atualizarProduto(id, produtoDto);
            Map<String, Object> result = new HashMap<>();
            result.put("success", true);
            result.put("message", "Produto atualizado com sucesso");
            result.put("produto", produto);
            System.out.println("Produto atualizado com sucesso: " + produto.getId());
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            System.out.println("Erro ao atualizar produto: " + e.getMessage());
            e.printStackTrace();
            Map<String, Object> result = new HashMap<>();
            result.put("success", false);
            result.put("message", "Erro ao atualizar produto: " + e.getMessage());
            return ResponseEntity.badRequest().body(result);
        }
    }
    
    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<?> excluirProduto(@PathVariable Long id) {
        try {
            produtoService.excluirProduto(id);
            Map<String, Object> result = new HashMap<>();
            result.put("success", true);
            result.put("message", "Produto excluído com sucesso");
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            Map<String, Object> result = new HashMap<>();
            result.put("success", false);
            result.put("message", "Erro ao excluir produto: " + e.getMessage());
            return ResponseEntity.badRequest().body(result);
        }
    }
} 