package com.example.Revisao_Para_Prova.Controller;

import com.example.Revisao_Para_Prova.Model.ClientesModel;
import com.example.Revisao_Para_Prova.Services.ClientesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cliente")
public class ClientesController {

    @Autowired
    private ClientesServices service;


    @GetMapping
    public List<ClientesModel> listar() {
        return service.listarTodos();
    }


    @GetMapping("/{id}")
    public ResponseEntity<ClientesModel> buscarPorId(@PathVariable Long id) {
        ClientesModel cliente = service.buscarPorId(id);
        return ResponseEntity.ok(cliente);
    }


    @PostMapping
    public ResponseEntity<Map<String, Object>> salvar(@RequestBody ClientesModel cliente) {
        service.salvar(cliente);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("Mensagem", "Cliente Salvo com Sucesso"));
    }


    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> atualizar(
            @PathVariable Long id,
            @RequestBody ClientesModel cliente) {
        service.atualizarCliente(id, cliente);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("Mensagem", "Cliente Atualizado Com Sucesso"));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("Mensagem", "Cliente Excluido Com Sucesso"));
    }
}