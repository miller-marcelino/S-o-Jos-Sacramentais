package com.saojosesacramentais.Service;

import com.saojosesacramentais.Dto.FornecedoresDto;
import com.saojosesacramentais.Model.Fornecedores;
import com.saojosesacramentais.Repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedorService {
    
    @Autowired
    private FornecedorRepository fornecedorRepository;
    
    public Fornecedores cadastrarFornecedor(FornecedoresDto fornecedorDto) {
        // Verificar se CNPJ já existe
        if (fornecedorRepository.existsByCnpj(fornecedorDto.getCnpj())) {
            throw new RuntimeException("CNPJ já cadastrado");
        }
        
        // Verificar se email já existe
        if (fornecedorDto.getEmail() != null && !fornecedorDto.getEmail().trim().isEmpty()) {
            if (fornecedorRepository.existsByEmail(fornecedorDto.getEmail())) {
                throw new RuntimeException("E-mail já cadastrado");
            }
        }
        
        // Criar fornecedor
        Fornecedores fornecedor = new Fornecedores();
        fornecedor.setRazaoSocial(fornecedorDto.getRazaoSocial());
        fornecedor.setNomeFantasia(fornecedorDto.getNomeFantasia());
        fornecedor.setCnpj(fornecedorDto.getCnpj());
        fornecedor.setInscricaoEstadual(fornecedorDto.getInscricaoEstadual());
        fornecedor.setInscricaoMunicipal(fornecedorDto.getInscricaoMunicipal());
        fornecedor.setTelefone(fornecedorDto.getTelefone());
        fornecedor.setCelular(fornecedorDto.getCelular());
        fornecedor.setEmail(fornecedorDto.getEmail());
        fornecedor.setSite(fornecedorDto.getSite());
        
        return fornecedorRepository.save(fornecedor);
    }
    
    public List<Fornecedores> listarTodosFornecedores() {
        return fornecedorRepository.findAll();
    }
    
    public Fornecedores buscarFornecedorPorId(Long id) {
        return fornecedorRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Fornecedor não encontrado"));
    }
    
    public Fornecedores buscarFornecedorPorCnpj(String cnpj) {
        return fornecedorRepository.findByCnpj(cnpj)
            .orElseThrow(() -> new RuntimeException("Fornecedor não encontrado"));
    }

    public Fornecedores editarFornecedor(Long id, FornecedoresDto fornecedorDto) {
        Fornecedores fornecedor = fornecedorRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Fornecedor não encontrado"));

        fornecedor.setRazaoSocial(fornecedorDto.getRazaoSocial());
        fornecedor.setNomeFantasia(fornecedorDto.getNomeFantasia());
        fornecedor.setCnpj(fornecedorDto.getCnpj());
        fornecedor.setInscricaoEstadual(fornecedorDto.getInscricaoEstadual());
        fornecedor.setInscricaoMunicipal(fornecedorDto.getInscricaoMunicipal());
        fornecedor.setTelefone(fornecedorDto.getTelefone());
        fornecedor.setCelular(fornecedorDto.getCelular());
        fornecedor.setEmail(fornecedorDto.getEmail());
        fornecedor.setSite(fornecedorDto.getSite());

        return fornecedorRepository.save(fornecedor);
    }

    public void excluirFornecedor(Long id) {
        if (!fornecedorRepository.existsById(id)) {
            throw new RuntimeException("Fornecedor não encontrado");
        }
        fornecedorRepository.deleteById(id);
    }
} 