package com.saojosesacramentais.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDto {
    private String descricao;
    private String tipoItem;
    private String unidadeMedida;
    private String categoria;
    private String subcategoria;
    private String marca;
    private String modelo;
    private BigDecimal custo;
    private BigDecimal precoVenda;
    private BigDecimal margemLucro;
    private String foto;
    private Boolean destaque;
    
    @Override
    public String toString() {
        return "ProdutoDto{" +
                "descricao='" + descricao + '\'' +
                ", tipoItem='" + tipoItem + '\'' +
                ", unidadeMedida='" + unidadeMedida + '\'' +
                ", categoria='" + categoria + '\'' +
                ", subcategoria='" + subcategoria + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", custo=" + custo +
                ", precoVenda=" + precoVenda +
                ", margemLucro=" + margemLucro +
                ", foto='" + (foto != null ? foto.substring(0, Math.min(foto.length(), 50)) + "..." : "null") + '\'' +
                ", destaque=" + destaque +
                '}';
    }

    public Boolean getDestaque() {
        return destaque;
    }

    public void setDestaque(Boolean destaque) {
        this.destaque = destaque;
    }
} 