package com.example.AtividadePontuada.service;

import com.example.AtividadePontuada.model.ClientesModel;
import com.example.AtividadePontuada.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientesService {
    @Autowired
    private ClientesRepository repository;

    public List<ClientesModel> listarTodos(){
        return repository.findAll();
    }

    public ClientesModel salvar(ClientesModel cliente){
        if (repository.findByEmail(cliente.getEmail()).isPresent()){
            throw new RuntimeException("Cliente já Cadastrado");
        }
        return repository.save(cliente);
    }

    public ClientesModel atualizarCliente(Long id, ClientesModel cliente){
        if (!repository.existsById(id)){
            throw new IllegalArgumentException("Cliente não encontrado");
        }
        cliente.setId(id);
        return repository.save(cliente);
    }

    public void excluir(Long id){
        if (!repository.existsById(id)){
            throw new IllegalArgumentException("Cliente não encontrado");
        }
        repository.deleteById(id);
    }
}
