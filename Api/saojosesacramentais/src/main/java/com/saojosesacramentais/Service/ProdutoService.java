package com.saojosesacramentais.Service;

import com.saojosesacramentais.Dto.ProdutoDto;
import com.saojosesacramentais.Model.Produtos;
import com.saojosesacramentais.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository produtoRepository;
    
    public Produtos criarProduto(ProdutoDto produtoDto) {
        Produtos produto = new Produtos();
        
        produto.setDescricao(produtoDto.getDescricao());
        produto.setTipoItem(Produtos.TipoItem.valueOf(produtoDto.getTipoItem()));
        produto.setUnidadeMedida(Produtos.UnidadeMedida.valueOf(produtoDto.getUnidadeMedida()));
        produto.setCategoria(produtoDto.getCategoria());
        produto.setSubcategoria(produtoDto.getSubcategoria());
        produto.setMarca(produtoDto.getMarca());
        produto.setModelo(produtoDto.getModelo());
        produto.setCusto(produtoDto.getCusto());
        produto.setPrecoVenda(produtoDto.getPrecoVenda());
        produto.setMargemLucro(produtoDto.getMargemLucro());
        produto.setFoto(produtoDto.getFoto());
        produto.setDestaque(produtoDto.getDestaque() != null ? produtoDto.getDestaque() : false);
        
        return produtoRepository.save(produto);
    }
    
    public List<Produtos> listarTodosProdutos() {
        return produtoRepository.findAll();
    }

    public Produtos atualizarProduto(Long id, ProdutoDto produtoDto) {
        System.out.println("Service: Atualizando produto ID: " + id);
        Optional<Produtos> opt = produtoRepository.findById(id);
        if (opt.isEmpty()) {
            System.out.println("Service: Produto não encontrado com ID: " + id);
            throw new RuntimeException("Produto não encontrado");
        }
        Produtos produto = opt.get();
        System.out.println("Service: Produto encontrado: " + produto.getDescricao());
        
        produto.setDescricao(produtoDto.getDescricao());
        produto.setTipoItem(Produtos.TipoItem.valueOf(produtoDto.getTipoItem()));
        produto.setUnidadeMedida(Produtos.UnidadeMedida.valueOf(produtoDto.getUnidadeMedida()));
        produto.setCategoria(produtoDto.getCategoria());
        produto.setSubcategoria(produtoDto.getSubcategoria());
        produto.setMarca(produtoDto.getMarca());
        produto.setModelo(produtoDto.getModelo());
        produto.setCusto(produtoDto.getCusto());
        produto.setPrecoVenda(produtoDto.getPrecoVenda());
        produto.setMargemLucro(produtoDto.getMargemLucro());
        produto.setFoto(produtoDto.getFoto());
        produto.setDestaque(produtoDto.getDestaque() != null ? produtoDto.getDestaque() : false);
        
        Produtos produtoSalvo = produtoRepository.save(produto);
        System.out.println("Service: Produto salvo com sucesso: " + produtoSalvo.getId());
        return produtoSalvo;
    }
    
    public void excluirProduto(Long id) {
        Optional<Produtos> opt = produtoRepository.findById(id);
        if (opt.isEmpty()) {
            throw new RuntimeException("Produto não encontrado");
        }
        produtoRepository.deleteById(id);
    }
} 