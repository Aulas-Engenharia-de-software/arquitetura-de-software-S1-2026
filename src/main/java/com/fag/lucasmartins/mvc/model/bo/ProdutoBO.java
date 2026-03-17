package com.fag.lucasmartins.mvc.model.bo;

public class ProdutoBO {
    private Long id;
    private String nome;
    private Double preco;
    private Integer quantidade;

    public ProdutoBO() {
    }

    public ProdutoBO(Long id, String nome, Double preco, Integer quantidade) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public void aplicarDescontoAtacado() {
        if (this.quantidade != null && this.quantidade > 100) {
            this.preco = this.preco * 0.90;
        }
    }

    public String getNome() {
        return nome;
    }

    public Double getPreco() {
        return preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }
}