package com.saojosesacramentais.Dto;

import com.saojosesacramentais.Model.Produtos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutosDto {
    
    private Long id;
    private String descricao;
    private Produtos.TipoItem tipoItem;
    private Produtos.UnidadeMedida unidadeMedida;
    private String categoria;
    private String subcategoria;
    private String marca;
    private String modelo;
    private BigDecimal custo;
    private BigDecimal precoVenda;
    private BigDecimal margemLucro;
    private Boolean destaque;
    
    // Construtor para conversão de Entity para DTO
    public ProdutosDto(Produtos produtos) {
        this.id = produtos.getId();
        this.descricao = produtos.getDescricao();
        this.tipoItem = produtos.getTipoItem();
        this.unidadeMedida = produtos.getUnidadeMedida();
        this.categoria = produtos.getCategoria();
        this.subcategoria = produtos.getSubcategoria();
        this.marca = produtos.getMarca();
        this.modelo = produtos.getModelo();
        this.custo = produtos.getCusto();
        this.precoVenda = produtos.getPrecoVenda();
        this.margemLucro = produtos.getMargemLucro();
        this.destaque = produtos.getDestaque();
    }

    public Boolean getDestaque() {
        return destaque;
    }

    public void setDestaque(Boolean destaque) {
        this.destaque = destaque;
    }
} 