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

        validarPremium();
        calcularDescontoAtacado();
    }

    private void validarPremium() {
        if (nome != null && nome.toLowerCase().contains("premium")) {
            if (preco < 100.0) {
                throw new RuntimeException("Produtos Premium não podem custar menos de R$ 100");
            }
        }
    }

    private void calcularDescontoAtacado() {
        if (estoque != null && estoque >= 50) {
            this.precoFinal = preco - (preco * 0.10);
        } else {
            this.precoFinal = preco;
        }
    }

    public String getNome() {
        return nome;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public double getPreco() {
        return preco;
    }

    public double getPrecoFinal() {
        return precoFinal;
    }
}