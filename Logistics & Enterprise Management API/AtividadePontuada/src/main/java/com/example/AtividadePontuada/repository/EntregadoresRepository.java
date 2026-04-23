package com.example.AtividadePontuada.repository;

import com.example.AtividadePontuada.model.EntregadoresModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EntregadoresRepository extends JpaRepository<EntregadoresModel, Long> {
    Optional<EntregadoresModel> findByEmail (String email);
}
