package com.fag.lucasmartins.arquitetura_software.model;

public class Produto {
    private Long id;
    private String nome;
    private double preco;
    private double precoFinal;
    private int estoque;

    public Produto(String nome, double preco, int estoque) {
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
        this.precoFinal = calcularPrecoFinal();
    }

    public void validar() {
        if (nome != null && nome.toLowerCase().contains("premium")) {
            if (preco < 100.0) {
                throw new IllegalArgumentException("Produtos Premium não podem custar menos de R$ 100,00.");
            }
        }
    }

    private double calcularPrecoFinal() {
        if (estoque >= 50) {
            return preco - (preco * 0.10); // 10% desconto
        }
        return preco;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
        this.precoFinal = calcularPrecoFinal();
    }

    public double getPrecoFinal() {
        return precoFinal;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
        this.precoFinal = calcularPrecoFinal();
    }
}