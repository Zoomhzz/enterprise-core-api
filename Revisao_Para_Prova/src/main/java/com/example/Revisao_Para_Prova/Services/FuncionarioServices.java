package com.example.Revisao_Para_Prova.Services;

import com.example.Revisao_Para_Prova.Model.FuncionarioModel;
import com.example.Revisao_Para_Prova.Repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioServices {

    @Autowired
    private FuncionarioRepository repository;

    public List<FuncionarioModel> listarTodos(){
        return repository.findAll();

    }

    public FuncionarioModel salvar(FuncionarioModel funcionario){
        if(repository.findByEmail(funcionario.getEmail()).isPresent()){
            throw new RuntimeException("Funcionário Já Cadastrado");
        }
        return repository.save(funcionario);
    }

    public FuncionarioModel atualizarfuncionario(Long id, FuncionarioModel funcionario){
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Funcionario não Encontrado");
        }
        funcionario.setId(id);
        return repository.save(funcionario);
    }

    public void excluir(Long id) {
        if (!repository.existsById(id)){
            throw new IllegalArgumentException("Funcionário não Encontraodo");
        }
        repository.deleteById(id);
    }

}
