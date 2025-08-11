package com.saojosesacramentais.Service;

import com.saojosesacramentais.Model.Pedidos;
import com.saojosesacramentais.Model.Clientes;
import com.saojosesacramentais.Repository.PedidoRepository;
import com.saojosesacramentais.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Pedidos> listarPedidosPorCliente(Long clienteId) {
        Clientes cliente = clienteRepository.findById(clienteId)
            .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        return pedidoRepository.findByCliente(cliente);
    }
} 