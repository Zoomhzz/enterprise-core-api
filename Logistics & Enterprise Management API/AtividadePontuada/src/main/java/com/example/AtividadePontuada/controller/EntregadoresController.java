package com.example.AtividadePontuada.controller;

import com.example.AtividadePontuada.model.EntregadoresModel;
import com.example.AtividadePontuada.model.ProdutosModel;
import com.example.AtividadePontuada.service.EntregadoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/entregadores")
public class EntregadoresController {
    @Autowired
    private EntregadoresService service;

    @GetMapping
    public List<EntregadoresModel> listar(){
        return service.listarTodos();
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> salvar(@RequestBody EntregadoresModel entregadores){
        service.salvar(entregadores);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("Mensagem","Entregador cadastrado Com Sucesso"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> atualizar(
            @PathVariable Long id,
            @RequestBody EntregadoresModel entregadores){
        service.atualizarEntregador(id, entregadores);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("Mensagem","Entregador atualizado com sucesso"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> excluir(@PathVariable Long id){
        service.excluir(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("Mensagem","Entregador excluido com sucesso"));
    }


}
