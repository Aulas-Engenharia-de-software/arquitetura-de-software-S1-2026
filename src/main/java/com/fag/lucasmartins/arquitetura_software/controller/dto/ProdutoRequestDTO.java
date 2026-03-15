package com.fag.lucasmartins.arquitetura_software.controller.dto;

public class ProdutoRequestDTO extends BaseProdutoDTO {
    public ProdutoRequestDTO() {
        super();
    }

    public ProdutoRequestDTO(String nome, Integer estoque, double preco) {
        super(nome, estoque, preco);
    }
}
