package com.saojosesacramentais.Repository;

import com.saojosesacramentais.Model.Depoimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DepoimentoRepository extends JpaRepository<Depoimento, Long> {
    List<Depoimento> findByVisivelOrderByDataCriacaoDesc(Boolean visivel);
    List<Depoimento> findByClienteIdOrderByDataCriacaoDesc(Long clienteId);
    List<Depoimento> findAllByOrderByDataCriacaoDesc();
} 