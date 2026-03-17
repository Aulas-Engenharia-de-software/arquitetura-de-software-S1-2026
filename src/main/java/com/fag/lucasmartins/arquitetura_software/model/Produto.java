package com.fag.lucasmartins.arquitetura_software.model;

public class Produto {

    private String nome;
    private Integer estoque;
    private Double preco;

    public Produto(String nome, Integer estoque, Double preco) {
        this.nome = nome;
        this.estoque = estoque;
        this.preco = preco;
    }

    public boolean isPremium() {
        return nome != null && nome.toLowerCase().contains("premium");
    }

    public double calcularPrecoFinal() {
        if (estoque != null && estoque >= 50) {
            return preco - (preco * 0.10);
        }
        return preco;
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
}