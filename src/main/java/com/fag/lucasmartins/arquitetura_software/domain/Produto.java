package com.fag.lucasmartins.arquitetura_software.domain;

public class Produto {
    private String nome;
    private Integer estoque;
    private double preco;
    private double precoFinal;

    public Produto(String nome, Integer estoque, double preco) {
        this.nome = nome;
        this.estoque = estoque;
        this.preco = preco;
        this.precoFinal = preco; 
    }

    public void validarRegras() {
         if (this.nome != null && this.nome.toLowerCase().contains("premium")) {
              if (preco < 100.0) {
                throw new IllegalArgumentException("Erro: Produtos Premium não podem custar menos de R$ 100,00.");
              }
         }
    }

    public void calcularPrecoFinal() {
         if (this.estoque != null && this.estoque >= 50) {
             this.precoFinal = this.preco - (this.preco * 0.10);
    }
    
}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getPrecoFinal() {
        return precoFinal;
    }

    public void setPrecoFinal(double precoFinal) {
        this.precoFinal = precoFinal;
    }
}