package com.example.Revisao_Para_Prova.Controller;

import com.example.Revisao_Para_Prova.Model.FuncionarioModel;
import com.example.Revisao_Para_Prova.Services.FuncionarioServices;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
    @Autowired
    private FuncionarioServices service;

    @GetMapping
    public List<FuncionarioModel> listar(){
        return service.listarTodos();
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> salvar(@RequestBody FuncionarioModel funcionario){
        service.salvar(funcionario);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("Mensagem","Funcionário Salvo com Sucesso"));
    }


    @PutMapping("/{id}")
        public ResponseEntity<Map<String,Object>> atualizar (
               @PathVariable Long id,
               @RequestBody FuncionarioModel funcionario){
        service.atualizarfuncionario(id, funcionario);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("Mensagem","Funcionário Atualizado Com Sucesso"));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String,Object>> excluir(@PathVariable Long id) {
        service.excluir(id);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(Map.of("Mensagem","Funcionário Excluido Com Sucesso"));
    }

}


