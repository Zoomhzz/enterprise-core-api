package com.example.AtividadePontuada.repository;

import com.example.AtividadePontuada.model.FuncionariosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FuncionariosRepository extends JpaRepository<FuncionariosModel, Long> {
    Optional<FuncionariosModel> findByEmail(String email);
}
