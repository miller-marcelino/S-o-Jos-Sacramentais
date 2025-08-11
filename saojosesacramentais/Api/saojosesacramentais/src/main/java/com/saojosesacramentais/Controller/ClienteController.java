package com.saojosesacramentais.Controller;

import com.saojosesacramentais.Dto.ClientesDto;
import com.saojosesacramentais.Model.Clientes;
import com.saojosesacramentais.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin(origins = "*")
public class ClienteController {
    
    @Autowired
    private ClienteService clienteService;
    
    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrarCliente(@RequestBody ClientesDto clienteDto) {
        try {
            Clientes cliente = clienteService.cadastrarCliente(clienteDto);
            
            Map<String, Object> result = new HashMap<>();
            result.put("success", true);
            result.put("message", "Cliente cadastrado com sucesso! Um login foi criado automaticamente.");
            result.put("cliente", cliente);
            
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            Map<String, Object> result = new HashMap<>();
            result.put("success", false);
            result.put("message", "Erro ao cadastrar cliente: " + e.getMessage());
            return ResponseEntity.badRequest().body(result);
        }
    }
    
    @GetMapping("/listar")
    public ResponseEntity<?> listarClientes() {
        try {
            List<Clientes> clientes = clienteService.listarTodosClientes();
            
            Map<String, Object> result = new HashMap<>();
            result.put("success", true);
            result.put("clientes", clientes);
            result.put("total", clientes.size());
            
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            Map<String, Object> result = new HashMap<>();
            result.put("success", false);
            result.put("message", "Erro ao listar clientes: " + e.getMessage());
            return ResponseEntity.badRequest().body(result);
        }
    }
    
    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarClientePorId(@PathVariable Long id) {
        try {
            Clientes cliente = clienteService.buscarClientePorId(id);
            
            Map<String, Object> result = new HashMap<>();
            result.put("success", true);
            result.put("cliente", cliente);
            
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            Map<String, Object> result = new HashMap<>();
            result.put("success", false);
            result.put("message", "Erro ao buscar cliente: " + e.getMessage());
            return ResponseEntity.badRequest().body(result);
        }
    }
} 