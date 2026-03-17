package com.fag.lucasmartins.arquitetura_software.dto;

public class ProdutoRequestDTO extends ProdutoDTO {

    public ProdutoRequestDTO() {
        super();
    }

    public ProdutoRequestDTO(String nome, double preco, int estoque) {
        super(nome, preco, estoque);
    }
}