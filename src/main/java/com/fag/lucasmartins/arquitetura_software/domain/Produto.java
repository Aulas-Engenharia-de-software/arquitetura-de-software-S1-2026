package com.fag.lucasmartins.arquitetura_software.domain;

public class Produto {

    private String nome;
    private Integer estoque;
    private Double preco;
    private Double precoFinal;

    public Produto(String nome, Integer estoque, Double preco) {
        this.nome = nome;
        this.estoque = estoque;
        this.preco = preco;

        validar();
        aplicarRegras();
    }

    private void validar() {
        if (nome != null && nome.toLowerCase().contains("premium")) {
            if (preco < 100.0) {
                throw new IllegalArgumentException("Produtos Premium não podem custar menos de R$ 100,00.");
            }
        }
    }

    private void aplicarRegras() {
        this.precoFinal = preco;

        if (estoque != null && estoque >= 50) {
            this.precoFinal = preco - (preco * 0.10);
        }
    }

    public String getNome() { return nome; }
    public Integer getEstoque() { return estoque; }
    public Double getPreco() { return preco; }
    public Double getPrecoFinal() { return precoFinal; }
}