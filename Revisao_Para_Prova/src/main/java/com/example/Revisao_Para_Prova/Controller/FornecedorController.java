package com.example.Revisao_Para_Prova.Controller;

import com.example.Revisao_Para_Prova.Model.FornecedorModel;
import com.example.Revisao_Para_Prova.Services.FornecedorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
    @RequestMapping("/fornecedores")
    public class FornecedorController {

        @Autowired
        private FornecedorServices service;

        @GetMapping
        public List<FornecedorModel> listar() {
            return service.listarTodos();
        }


        @GetMapping("/{cnpj}")
        public ResponseEntity<FornecedorModel> buscarPorCnpj(@PathVariable String cnpj) {
            FornecedorModel fornecedor = service.buscarPorCnpj(cnpj);
            return ResponseEntity.ok(fornecedor);
        }

        @PostMapping
        public ResponseEntity<Map<String, Object>> salvar(@RequestBody FornecedorModel fornecedor) {
            service.salvar(fornecedor);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(Map.of("Mensagem", "Fornecedor Salvo com Sucesso"));
        }
    }

