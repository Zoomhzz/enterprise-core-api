package com.example.Revisao_Para_Prova.Services;

import com.example.Revisao_Para_Prova.Model.ClientesModel;
import com.example.Revisao_Para_Prova.Repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientesServices {
    @Autowired
    private ClientesRepository repository;

    public List<ClientesModel> listarTodos(){
        return repository.findAll();
    }

    public ClientesModel buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cliente de ID" + id + "Não Encontrado"));
    }

    public ClientesModel salvar(ClientesModel cliente) {
        if (cliente.getId() != null && repository.existsById(cliente.getId())) {
            throw new RuntimeException("Cliente já cadastrado");
        }
      return repository.save(cliente);
    }

    public ClientesModel atualizarCliente(Long id, ClientesModel cliente) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Cliente não encontrado");
        }
        cliente.setId(id);
        return repository.save(cliente);
    }

    public void excluir(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Cliente não encontrado");
        }
        repository.deleteById(id);
    }

}
