package com.fag.lucasmartins.arquitetura_software.model;

public class Produto {

    private String nome;
    private double preco;
    private int estoque;
    private double precoFinal;

    public Produto(String nome, double preco, int estoque) {
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }

    public void aplicarRegras() {
        if (nome != null && nome.toLowerCase().contains("premium")) {
            if (preco < 100.0) {
                throw new RuntimeException("Produto premium deve custar no mínimo 100");
            }
        }

        if (estoque >= 50) {
            precoFinal = preco - (preco * 0.10);
        } else {
            precoFinal = preco;
        }
    }

    public double getPrecoFinal() {
        return precoFinal;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getEstoque() {
        return estoque;
    }
}