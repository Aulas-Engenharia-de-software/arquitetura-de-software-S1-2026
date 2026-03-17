package com.fag.lucasmartins.arquitetura_software.view.dto;

public class ProdutoDTO {

    private String nome;
    private Integer estoque;
    private Double preco;

    public ProdutoDTO() {}

    public ProdutoDTO(String nome, Integer estoque, Double preco) {
        this.nome = nome;
        this.estoque = estoque;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public Double getPreco() {
        return preco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}