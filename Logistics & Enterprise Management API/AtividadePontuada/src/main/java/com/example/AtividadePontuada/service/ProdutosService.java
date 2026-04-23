package com.example.AtividadePontuada.service;

import com.example.AtividadePontuada.model.ProdutosModel;
import com.example.AtividadePontuada.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutosService {
    @Autowired
    private ProdutosRepository repository;

    public List<ProdutosModel> listarTodos(){
        return repository.findAll();
    }

    public ProdutosModel salvar (ProdutosModel produtos){
        if (repository.findByLote(produtos.getLote()).isPresent()){
            throw new RuntimeException("Produto já cadastrado.");
        }
        return repository.save(produtos);
    }

    public ProdutosModel atualizarproduto(Long id,ProdutosModel produtos){
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Produto não encontrado");
        }
        produtos.setId(id);
        return repository.save(produtos);
    }

    public void excluir(Long id){
        if (!repository.existsById(id)){
            throw new IllegalArgumentException("Produto não encontrado");
        }
        repository.deleteById(id);
    }
}
