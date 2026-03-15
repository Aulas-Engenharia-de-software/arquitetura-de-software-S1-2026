package com.fag.lucasmartins.arquitetura_software.model;

import java.util.Locale;

public class Produto {
    private Integer id;
    private String nome;
    private double preco;
    private double precoFinal;
    private Integer estoque;

    public Produto(Integer id, String nome, double preco, double precoFinal, Integer estoque) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.precoFinal = precoFinal;
        this.estoque = estoque;
    }

    public Produto(String nome, double preco, Integer estoque) {
        this(null, nome, preco, preco, estoque);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public boolean isPremium() {
        return nome != null && nome.toLowerCase(Locale.ROOT).contains("premium");
    }

    public void validarRegrasDeNegocio() {
        if (isPremium() && preco < 100.0) {
            throw new IllegalArgumentException("Produtos Premium não podem custar menos de R$ 100,00.");
        }
    }

    public void aplicarDescontoAtacadoSeAplicavel() {
        this.precoFinal = this.preco;
        if (estoque != null && estoque >= 50) {
            this.precoFinal = this.preco - (this.preco * 0.10);
        }
    }
}
