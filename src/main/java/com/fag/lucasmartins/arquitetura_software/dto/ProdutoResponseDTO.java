package com.fag.lucasmartins.arquitetura_software.dto;

import com.fag.lucasmartins.arquitetura_software.domain.Produto;

public class ProdutoResponseDTO {

    private String nome;
    private Integer estoque;
    private Double preco;
    private Double precoFinal;

    public ProdutoResponseDTO(Produto produto) {
        this.nome = produto.getNome();
        this.estoque = produto.getEstoque();
        this.preco = produto.getPreco();
        this.precoFinal = produto.getPrecoFinal();
    }

    // getters
}