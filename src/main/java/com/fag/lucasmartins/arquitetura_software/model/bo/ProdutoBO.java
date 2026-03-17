package com.fag.lucasmartins.arquitetura_software.model.bo;

public class ProdutoBO {

    private String nome;
    private Integer estoque;
    private Double preco;
    private Double precoFinal;

    public ProdutoBO(String nome, Integer estoque, Double preco) {
        this.nome = nome;
        this.estoque = estoque;
        this.preco = preco;
        this.precoFinal = calcularPrecoFinal();
    }

    private Double calcularPrecoFinal() {

        if (nome != null && nome.toLowerCase().contains("premium")) {
            if (preco < 100.0) {
                throw new RuntimeException("Produtos Premium não podem custar menos de R$ 100,00.");
            }
        }

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

    public Double getPrecoFinal() {
        return precoFinal;
    }
}