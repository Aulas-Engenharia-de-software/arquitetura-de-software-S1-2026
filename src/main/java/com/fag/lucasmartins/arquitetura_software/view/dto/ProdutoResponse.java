package com.fag.lucasmartins.arquitetura_software.view.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProdutoResponse {
    private String mensagem;
    private String nome;
    private Integer estoque;
    private double preco;
    @JsonProperty("preco_final")
    private double precoFinal;

    public ProdutoResponse() {
    }

    public ProdutoResponse(String mensagem, String nome, Integer estoque, double preco, double precoFinal) {
        this.mensagem = mensagem;
        this.nome = nome;
        this.estoque = estoque;
        this.preco = preco;
        this.precoFinal = precoFinal;
    }

    public String getMensagem() {
        return mensagem;
    }

    public String getNome() {
        return nome;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public double getPreco() {
        return preco;
    }

    public double getPrecoFinal() {
        return precoFinal;
    }
}
