package com.saojosesacramentais.Repository;

import com.saojosesacramentais.Model.Pedidos;
import com.saojosesacramentais.Model.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedidos, Long> {
    List<Pedidos> findByCliente(Clientes cliente);
} 