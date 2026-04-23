package com.example.AtividadePontuada.repository;

import com.example.AtividadePontuada.model.ClientesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientesRepository extends JpaRepository<ClientesModel, Long> {
    Optional<ClientesModel> findByEmail (String email);

}
