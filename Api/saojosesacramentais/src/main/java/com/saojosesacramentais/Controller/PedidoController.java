package com.saojosesacramentais.Controller;

import com.saojosesacramentais.Model.Pedidos;
import com.saojosesacramentais.Service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/pedidos")
@CrossOrigin(origins = "*")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<?> listarPedidosPorCliente(@PathVariable Long clienteId) {
        try {
            List<Pedidos> pedidos = pedidoService.listarPedidosPorCliente(clienteId);
            Map<String, Object> result = new HashMap<>();
            result.put("success", true);
            result.put("pedidos", pedidos);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            Map<String, Object> result = new HashMap<>();
            result.put("success", false);
            result.put("message", "Erro ao listar pedidos: " + e.getMessage());
            return ResponseEntity.badRequest().body(result);
        }
    }
} 