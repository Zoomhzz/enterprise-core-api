package com.example.AtividadePontuada.service;

import com.example.AtividadePontuada.model.ClientesModel;
import com.example.AtividadePontuada.model.EntregadoresModel;
import com.example.AtividadePontuada.repository.EntregadoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntregadoresService {
    @Autowired
    EntregadoresRepository repository;

    public List<EntregadoresModel> listarTodos(){
        return repository.findAll();
    }

    public EntregadoresModel salvar(EntregadoresModel entregadores){
        if (repository.findByEmail(entregadores.getEmail()).isPresent()){
            throw new RuntimeException("Entregador já Cadastrado");
        }
        return repository.save(entregadores);
    }

    public EntregadoresModel atualizarEntregador(Long id, EntregadoresModel entregadores){
        if (!repository.existsById(id)){
            throw new IllegalArgumentException("Entregador não encontrado");
        }
       entregadores.setId(id);
        return repository.save(entregadores);
    }

    public void excluir(Long id){
        if (!repository.existsById(id)){
            throw new IllegalArgumentException("Entregador não encontrado");
        }
        repository.deleteById(id);
    }
}
