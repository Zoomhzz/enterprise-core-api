package com.example.Revisao_Para_Prova.Repository;

import com.example.Revisao_Para_Prova.Model.ClientesModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientesRepository extends JpaRepository<ClientesModel, Long> {


}
