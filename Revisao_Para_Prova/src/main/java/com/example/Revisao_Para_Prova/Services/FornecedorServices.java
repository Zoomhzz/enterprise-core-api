package com.example.Revisao_Para_Prova.Services;

import com.example.Revisao_Para_Prova.Model.FornecedorModel;
import com.example.Revisao_Para_Prova.Repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedorServices {
    @Autowired
    private FornecedorRepository repository;

    public List<FornecedorModel> listarTodos() {
        return repository.findAll();
    }

    public FornecedorModel buscarPorCnpj(String cnpj) {
        return repository.findByCnpj(cnpj)
                .orElseThrow(() -> new IllegalArgumentException("Fornecedor com CNPJ " + cnpj + " não encontrado"));
    }

    public FornecedorModel salvar(FornecedorModel fornecedor) {
        if (repository.findByCnpj(fornecedor.getCnpj()).isPresent()) {
            throw new RuntimeException("CNPJ já cadastrado no sistema");
        }
        return repository.save(fornecedor);
    }

    public void excluir(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Fornecedor não encontrado");
        }
        repository.deleteById(id);
    }
}

