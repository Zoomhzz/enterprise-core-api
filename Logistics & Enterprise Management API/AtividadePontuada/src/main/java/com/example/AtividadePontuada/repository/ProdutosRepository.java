package com.example.AtividadePontuada.repository;

import com.example.AtividadePontuada.model.ProdutosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProdutosRepository extends JpaRepository<ProdutosModel, Long> {
    Optional<ProdutosModel> findByLote (String Lote);
}
