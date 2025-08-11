package com.saojosesacramentais.Service;

import com.saojosesacramentais.Dto.ClientesDto;
import com.saojosesacramentais.Model.Clientes;
import com.saojosesacramentais.Model.Usuario;
import com.saojosesacramentais.Repository.ClienteRepository;
import com.saojosesacramentais.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository clienteRepository;
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    public Clientes cadastrarCliente(ClientesDto clienteDto) {
        // Verificar se email já existe
        if (clienteRepository.existsByEmail(clienteDto.getEmail())) {
            throw new RuntimeException("E-mail já cadastrado");
        }
        
        // Verificar se CPF/CNPJ já existe
        if (clienteDto.getCpfCnpj() != null && !clienteDto.getCpfCnpj().trim().isEmpty()) {
            if (clienteRepository.existsByCpfCnpj(clienteDto.getCpfCnpj())) {
                throw new RuntimeException("CPF/CNPJ já cadastrado");
            }
        }
        
        // Criar cliente
        Clientes cliente = new Clientes();
        cliente.setNomeCompleto(clienteDto.getNomeCompleto());
        cliente.setEmail(clienteDto.getEmail());
        cliente.setTelefone(clienteDto.getTelefone());
        cliente.setCpfCnpj(clienteDto.getCpfCnpj());
        cliente.setCep(clienteDto.getCep());
        cliente.setRua(clienteDto.getRua());
        cliente.setNumero(clienteDto.getNumero());
        cliente.setBairro(clienteDto.getBairro());
        cliente.setCidade(clienteDto.getCidade());
        cliente.setPais(clienteDto.getPais());
        cliente.setDataNascimento(clienteDto.getDataNascimento());
        cliente.setSexo(clienteDto.getSexo());
        
        Clientes clienteSalvo = clienteRepository.save(cliente);
        
        // Criar usuário automaticamente
        Usuario usuario = new Usuario();
        usuario.setEmail(clienteDto.getEmail());
        usuario.setSenha(clienteDto.getSenha());
        usuario.setTipo(Usuario.TipoUsuario.CLIENTE);
        usuario.setAtivo(true);
        
        usuarioRepository.save(usuario);
        
        return clienteSalvo;
    }
    
    public List<Clientes> listarTodosClientes() {
        return clienteRepository.findAll();
    }
    
    public Clientes buscarClientePorId(Long id) {
        return clienteRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }
    
    public Clientes buscarClientePorEmail(String email) {
        return clienteRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }
} 