package com.fag.lucasmartins.arquitetura_software.model;

public class Produto {

    private String nome;
    private double preco;
    private double precoFinal;
    private Integer estoque;

    public Produto(String nome, double preco, Integer estoque) {
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
        this.precoFinal = preco;
    }

    public void validarProdutoPremium() {

        if (nome != null && nome.toLowerCase().contains("premium")) {

            if (preco < 100) {
                throw new RuntimeException("Produto premium deve custar pelo menos 100");
            }

        }

    }

    public void aplicarDescontoAtacado() {

        if (estoque != null && estoque >= 50) {
            precoFinal = preco - (preco * 0.10);
        }

    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public double getPrecoFinal() {
        return precoFinal;
    }

    public Integer getEstoque() {
        return estoque;
    }
}