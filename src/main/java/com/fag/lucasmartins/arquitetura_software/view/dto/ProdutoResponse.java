package com.fag.lucasmartins.arquitetura_software.view.dto;

public class ProdutoResponse {
    private String mensagem;
    private String nome;
    private Integer estoque;
    private double preco;
    private double preco_final;

    public ProdutoResponse() {
    }

    public ProdutoResponse(String mensagem, String nome, Integer estoque, double preco, double preco_final) {
        this.mensagem = mensagem;
        this.nome = nome;
        this.estoque = estoque;
        this.preco = preco;
        this.preco_final = preco_final;
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

    public double getPreco_final() {
        return preco_final;
    }
}
