package com.example.AtividadePontuada.controller;

import com.example.AtividadePontuada.model.ProdutosModel;
import com.example.AtividadePontuada.service.ProdutosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutosService service;

    @GetMapping
    public List<ProdutosModel> listar(){
        return service.listarTodos();
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> salvar(@RequestBody ProdutosModel produto){
        service.salvar(produto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("Mensagem","Produto salvo Com Sucesso"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> atualizar(
            @PathVariable Long id,
            @RequestBody ProdutosModel produto){
        service.atualizarproduto(id, produto);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("Mensagem","Produto atualizado com sucesso"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> excluir(@PathVariable Long id){
        service.excluir(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("Mensagem","Produto excluido com sucesso"));
    }
}