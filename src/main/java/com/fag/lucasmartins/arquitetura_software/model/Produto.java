package com.fag.lucasmartins.arquitetura_software.model;    

public class Produto {

    private String nome;
    private Integer estoque;
    private Double preco;
    private Double precoFinal;

    public Produto(String nome, Integer estoque, Double preco) {
        this.nome = nome;
        this.estoque = estoque;
        this.preco = preco;
        aplicarRegras();
    }

    private void aplicarRegras() {
        validarProdutoPremium();
        aplicarDesconto();
    }

    private void validarProdutoPremium() {
        if (nome != null && nome.toLowerCase().contains("premium") && preco < 100) {
            throw new RuntimeException("Produto Premium não pode custar menos de 100");
        }
    }

    private void aplicarDesconto() {
        if (estoque != null && estoque >= 50) {
            this.precoFinal = preco - (preco * 0.10);
        } else {
            this.precoFinal = preco;
        }
    }

    public String getNome() { return nome; }
    public Integer getEstoque() { return estoque; }
    public Double getPreco() { return preco; }
    public Double getPrecoFinal() { return precoFinal; }
}