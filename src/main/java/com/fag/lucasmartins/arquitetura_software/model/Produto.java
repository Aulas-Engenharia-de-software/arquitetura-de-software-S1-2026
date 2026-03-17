package com.fag.lucasmartins.arquitetura_software.model;

public class Produto {
    private String nome;
    private Integer estoque;
    private double preco;
    private double precoFinal;

    public Produto(String nome, Integer estoque, double preco) {
        this.nome = nome;
        this.estoque = estoque != null ? estoque : 0;
        this.preco = preco;
        
        validarRegrasDeNegocio();
        calcularPrecoFinal();
    }

    private void validarRegrasDeNegocio() {
        if (this.nome != null && this.nome.toLowerCase().contains("premium")) {
            if (this.preco < 100.0) {
                throw new IllegalArgumentException("Erro: Produtos Premium não podem custar menos de R$ 100,00.");
            }
        }
    }

    private void calcularPrecoFinal() {
        if (this.estoque >= 50) {
            this.precoFinal = this.preco - (this.preco * 0.10); // 10% de desconto
        } else {
            this.precoFinal = this.preco;
        }
    }

    // Getters para uso da persistência e DTOs
    public String getNome() { return nome; }
    public Integer getEstoque() { return estoque; }
    public double getPreco() { return preco; }
    public double getPrecoFinal() { return precoFinal; }
}