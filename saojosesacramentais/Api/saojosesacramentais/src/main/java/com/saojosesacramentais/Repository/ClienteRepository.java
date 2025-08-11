package com.saojosesacramentais.Repository;

import com.saojosesacramentais.Model.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Clientes, Long> {
    Optional<Clientes> findByEmail(String email);
    boolean existsByEmail(String email);
    boolean existsByCpfCnpj(String cpfCnpj);
} 