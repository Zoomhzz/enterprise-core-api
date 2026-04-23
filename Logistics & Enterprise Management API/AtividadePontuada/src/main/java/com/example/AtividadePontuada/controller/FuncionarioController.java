package com.example.AtividadePontuada.controller;

import com.example.AtividadePontuada.model.ClientesModel;
import com.example.AtividadePontuada.model.FuncionariosModel;
import com.example.AtividadePontuada.service.ClientesService;
import com.example.AtividadePontuada.service.FuncionariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController { @Autowired
private FuncionariosService service;

    @GetMapping
    public List<FuncionariosModel> listar(){
        return service.listarTodos();
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> salvar(@RequestBody FuncionariosModel funcionario){
        service.salvar(funcionario);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("Mensagem","Funcionário salvo com sucesso"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> atulizar(
            @PathVariable Long id,
            @RequestBody FuncionariosModel funcionario){
        service.atualizarfuncionario(id,funcionario);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("Mensagem","Funcionário Atualizado Com sucesso"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> excluir(@PathVariable Long id){
        service.excluir(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("Mensagem","Funcionário excluido com sucesso"));
    }

}
