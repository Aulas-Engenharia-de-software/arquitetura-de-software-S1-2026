package com.fag.lucasmartins.arquitetura_software.model;

public class Produto {
    private String nome;
    private Double preco;
    private Double precoFinal;
    private Integer estoque;

    public Produto(String nome, Double preco, Integer estoque) {
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
        validarPremium(); 
        calcularDescontoAtacado(); 
    }

    private void validarPremium() {
        if (this.nome != null && this.nome.toLowerCase().contains("premium")) {
            if (this.preco < 100.0) {
                throw new IllegalArgumentException("Erro: Produtos Premium não podem custar menos de R$ 100,00.");
            }
        }
    }

    private void calcularDescontoAtacado() {
        this.precoFinal = this.preco;
        if (this.estoque != null && this.estoque >= 50) {
            this.precoFinal = this.preco - (this.preco * 0.10);
        }
    }

    
    public String getNome() { return nome; }
    public Double getPreco() { return preco; }
    public Double getPrecoFinal() { return precoFinal; }
    public Integer getEstoque() { return estoque; }
}