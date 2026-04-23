package com.example.AtividadePontuada.service;

import com.example.AtividadePontuada.model.FuncionariosModel;
import com.example.AtividadePontuada.model.ProdutosModel;
import com.example.AtividadePontuada.repository.FuncionariosRepository;
import com.example.AtividadePontuada.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionariosService {
    @Autowired
    private FuncionariosRepository repository;

    public List<FuncionariosModel> listarTodos(){
        return repository.findAll();
    }

    public FuncionariosModel salvar (FuncionariosModel funcionario){
        if (repository.findByEmail(funcionario.getEmail()).isPresent()){
            throw new RuntimeException("Funcionario já cadastrado.");
        }
        return repository.save(funcionario);
    }

    public FuncionariosModel atualizarfuncionario(Long id,FuncionariosModel funcionario){
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Funcionário não encontrado");
        }
        funcionario.setId(id);
        return repository.save(funcionario);
    }

    public void excluir(Long id){
        if (!repository.existsById(id)){
            throw new IllegalArgumentException("Funcionário não encontrado");
        }
        repository.deleteById(id);
    }

}
