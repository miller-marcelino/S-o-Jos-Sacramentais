package com.saojosesacramentais.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "pedidos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pedidos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Clientes cliente;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_pedido", nullable = false)
    private Date dataPedido;

    @Column(name = "valor_total", precision = 10, scale = 2, nullable = false)
    private BigDecimal valorTotal;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    private StatusPedido status;

    @Column(name = "observacao", length = 500)
    private String observacao;

    public enum StatusPedido {
        EM_ANDAMENTO,
        CONCLUIDO
    }
}
