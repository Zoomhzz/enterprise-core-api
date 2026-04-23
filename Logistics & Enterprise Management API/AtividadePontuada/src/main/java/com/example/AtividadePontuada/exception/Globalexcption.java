package com.example.AtividadePontuada.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;
import java.util.Objects;

@RestControllerAdvice
public class Globalexcption {
    @ExceptionHandler (RuntimeException.class)
    public ResponseEntity<Map<String, Object>> runtimeException(RuntimeException Erro){
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(Map.of("Mensagem",Erro.getMessage()));
    }


    @ExceptionHandler (IllegalArgumentException.class)
    public ResponseEntity<Map<String, Object>> IllegalArgumentException(IllegalArgumentException Erro){
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(Map.of("Mensagem",Erro.getMessage()));
    }


}
