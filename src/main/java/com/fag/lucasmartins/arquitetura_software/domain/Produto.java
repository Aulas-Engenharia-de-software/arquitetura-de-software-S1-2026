package com.fag.lucasmartins.arquitetura_software.domain;

public class Produto {

    private String nome;
    private Double preco;
    private Double precoFinal;
    private Integer estoque;

    public Produto(String nome, Double preco, Integer estoque) {
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;

        validar();
        this.precoFinal = calcularPrecoFinal();
    }

    private void validar() {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do produto é obrigatório.");
        }

        if (preco == null || preco <= 0) {
            throw new IllegalArgumentException("Preço deve ser maior que zero.");
        }

        if (estoque == null || estoque < 0) {
            throw new IllegalArgumentException("Estoque não pode ser negativo.");
        }

        if (nome.toLowerCase().contains("premium") && preco < 100.0) {
            throw new IllegalArgumentException("Produtos Premium não podem custar menos de R$ 100,00.");
        }
    }

    private Double calcularPrecoFinal() {
        if (estoque >= 50) {
            return preco - (preco * 0.10);
        }
        return preco;
    }

    public String getNome() {
        return nome;
    }

    public Double getPreco() {
        return preco;
    }

    public Double getPrecoFinal() {
        return precoFinal;
    }

    public Integer getEstoque() {
        return estoque;
    }
}