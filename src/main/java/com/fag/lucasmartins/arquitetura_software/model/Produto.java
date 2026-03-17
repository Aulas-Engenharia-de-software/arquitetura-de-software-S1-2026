package com.fag.lucasmartins.arquitetura_software.model;

public class Produto {
    private String nome;
    private double preco;
    private Integer estoque;

    public Produto(String nome, double preco, Integer estoque) {
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
        validarProdutoPremium();
    }

    private void validarProdutoPremium() {
        if (this.nome != null && this.nome.toLowerCase().contains("premium") && this.preco < 100.0) {
            throw new IllegalArgumentException("Erro: Produtos Premium não podem custar menos de R$ 100,00.");
        }
    }

    public double calcularPrecoFinal() {
        if (this.estoque != null && this.estoque >= 50) {
            return this.preco * 0.90;
        }
        return this.preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public Integer getEstoque() {
        return estoque;
    }
}