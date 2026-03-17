package com.fag.lucasmartins.arquitetura_software.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<DefaultErrorMessage> handleBadRequestException(BadRequestException e) {
        var defaultErrorMessage = new DefaultErrorMessage(e.getStatus().value(), e.getReason());
        return ResponseEntity.badRequest().body(defaultErrorMessage);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<DefaultErrorMessage> handleException(Exception e) {
        var defaultErrorMessage = new DefaultErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Erro ao processar requisição: " + e.getMessage());
        return ResponseEntity.internalServerError().body(defaultErrorMessage);
    }
}
