package com.fag.lucasmartins.arquitetura_software.controller.exception;

public class ProdutoPremiumPrecoInvalidoException extends RuntimeException {

    public ProdutoPremiumPrecoInvalidoException() {
        super("Produtos Premium não podem custar menos de R$ 100,00.");
    }
}