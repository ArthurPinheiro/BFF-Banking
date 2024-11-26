package com.baking.bff.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(value = ExceptionConfig.class)
    public ResponseEntity<Object> handleMethodArgumentNotValid(ExceptionConfig config) {

        List<Campo> campos = new ArrayList<>();
        var problema = new Problema();

        problema.setStatus(HttpStatus.BAD_REQUEST.value());
        problema.setTitulo(config.getMessage());
        problema.setDataHora(LocalDateTime.now());
        problema.setCampos(campos);

       return ResponseEntity.badRequest().body(problema);
    }
}
