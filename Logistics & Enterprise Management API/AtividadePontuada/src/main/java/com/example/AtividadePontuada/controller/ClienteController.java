package com.example.AtividadePontuada.controller;

import com.example.AtividadePontuada.model.ClientesModel;
import com.example.AtividadePontuada.service.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClientesService service;

    @GetMapping
    public List<ClientesModel> listar(){
        return service.listarTodos();
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> salvar(@RequestBody ClientesModel cliente){
        service.salvar(cliente);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("Mensagem","Cliente salvo com sucesso"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> atulizar(
            @PathVariable Long id,
            @RequestBody ClientesModel cliente){
        service.atualizarCliente(id,cliente);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("Mensagem","Cliente Atualizado Com sucesso"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> excluir(@PathVariable Long id){
        service.excluir(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("Mensagem","Cliente excluido com sucesso"));
    }

}
