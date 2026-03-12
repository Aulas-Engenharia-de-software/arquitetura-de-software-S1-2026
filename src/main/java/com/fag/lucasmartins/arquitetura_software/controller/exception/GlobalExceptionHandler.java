package com.fag.lucasmartins.arquitetura_software.controller.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProdutoPremiumPrecoInvalidoException.class)
    public ResponseEntity<String> handleProdutoPremium(ProdutoPremiumPrecoInvalidoException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
