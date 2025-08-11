package com.saojosesacramentais.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "produtos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produtos {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "descricao", nullable = false, length = 500)
    private String descricao;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_item", nullable = false, length = 20)
    private TipoItem tipoItem;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "unidade_medida", nullable = false, length = 20)
    private UnidadeMedida unidadeMedida;
    
    @Column(name = "categoria", length = 100)
    private String categoria;
    
    @Column(name = "subcategoria", length = 100)
    private String subcategoria;
    
    @Column(name = "marca", length = 100)
    private String marca;
    
    @Column(name = "modelo", length = 100)
    private String modelo;
    
    @Column(name = "custo", precision = 10, scale = 2)
    private BigDecimal custo;
    
    @Column(name = "preco_venda", precision = 10, scale = 2)
    private BigDecimal precoVenda;
    
    @Column(name = "margem_lucro", precision = 5, scale = 2)
    private BigDecimal margemLucro;
    
    @Column(name = "foto", columnDefinition = "LONGTEXT")
    private String foto;
    
    @Column(name = "destaque", nullable = false)
    private Boolean destaque = false;
    
    public enum TipoItem {
        PRODUTO,
        KIT,
        INSUMO,
        BRINDE
    }
    
    public enum UnidadeMedida {
        UNIDADE,
        CAIXA,
        FARDOS,
        QUILOGRAMA
    }

    public Boolean getDestaque() {
        return destaque;
    }

    public void setDestaque(Boolean destaque) {
        this.destaque = destaque;
    }
}
