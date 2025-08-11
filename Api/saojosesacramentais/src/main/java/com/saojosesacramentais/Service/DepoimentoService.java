package com.saojosesacramentais.Service;

import com.saojosesacramentais.Dto.DepoimentoDto;
import com.saojosesacramentais.Model.Depoimento;
import com.saojosesacramentais.Model.Clientes;
import com.saojosesacramentais.Repository.DepoimentoRepository;
import com.saojosesacramentais.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepoimentoService {
    
    @Autowired
    private DepoimentoRepository depoimentoRepository;
    
    @Autowired
    private ClienteRepository clienteRepository;
    
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    
    public Depoimento criarDepoimento(DepoimentoDto depoimentoDto) {
        // Verificar se o cliente existe
        Clientes cliente = clienteRepository.findById(depoimentoDto.getClienteId())
            .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        
        Depoimento depoimento = new Depoimento();
        depoimento.setTexto(depoimentoDto.getTexto());
        depoimento.setClienteId(cliente.getId());
        depoimento.setClienteNome(cliente.getNomeCompleto());
        depoimento.setClienteEmail(cliente.getEmail());
        depoimento.setVisivel(false); // Por padrão, não visível
        
        return depoimentoRepository.save(depoimento);
    }
    
    public List<DepoimentoDto> listarDepoimentosVisiveis() {
        List<Depoimento> depoimentos = depoimentoRepository.findByVisivelOrderByDataCriacaoDesc(true);
        return depoimentos.stream()
            .map(this::convertToDto)
            .collect(Collectors.toList());
    }
    
    public List<DepoimentoDto> listarTodosDepoimentos() {
        List<Depoimento> depoimentos = depoimentoRepository.findAllByOrderByDataCriacaoDesc();
        return depoimentos.stream()
            .map(this::convertToDto)
            .collect(Collectors.toList());
    }
    
    public List<DepoimentoDto> listarDepoimentosPorCliente(Long clienteId) {
        List<Depoimento> depoimentos = depoimentoRepository.findByClienteIdOrderByDataCriacaoDesc(clienteId);
        return depoimentos.stream()
            .map(this::convertToDto)
            .collect(Collectors.toList());
    }
    
    public Depoimento alterarVisibilidade(Long depoimentoId, Boolean visivel) {
        Depoimento depoimento = depoimentoRepository.findById(depoimentoId)
            .orElseThrow(() -> new RuntimeException("Depoimento não encontrado"));
        
        depoimento.setVisivel(visivel);
        if (visivel) {
            depoimento.setDataAprovacao(LocalDateTime.now());
        } else {
            depoimento.setDataAprovacao(null);
        }
        
        return depoimentoRepository.save(depoimento);
    }
    
    public void deletarDepoimento(Long depoimentoId) {
        if (!depoimentoRepository.existsById(depoimentoId)) {
            throw new RuntimeException("Depoimento não encontrado");
        }
        depoimentoRepository.deleteById(depoimentoId);
    }
    
    private DepoimentoDto convertToDto(Depoimento depoimento) {
        DepoimentoDto dto = new DepoimentoDto();
        dto.setId(depoimento.getId());
        dto.setTexto(depoimento.getTexto());
        dto.setClienteId(depoimento.getClienteId());
        dto.setClienteNome(depoimento.getClienteNome());
        dto.setClienteEmail(depoimento.getClienteEmail());
        dto.setVisivel(depoimento.getVisivel());
        
        if (depoimento.getDataCriacao() != null) {
            dto.setDataCriacao(depoimento.getDataCriacao().format(formatter));
        }
        
        if (depoimento.getDataAprovacao() != null) {
            dto.setDataAprovacao(depoimento.getDataAprovacao().format(formatter));
        }
        
        return dto;
    }
} 