package com.saojosesacramentais.Repository;

import com.saojosesacramentais.Model.Fornecedores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedores, Long> {
    Optional<Fornecedores> findByEmail(String email);
    Optional<Fornecedores> findByCnpj(String cnpj);
    boolean existsByEmail(String email);
    boolean existsByCnpj(String cnpj);
} 