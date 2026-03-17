package com.fag.lucasmartins.arquitetura_software.domain;

public class Produto {

    private String nome;
    private Integer estoque;
    private Double preco;
    private Double precoFinal;

    public void aplicarRegras() {
        validarPremium();
        aplicarDesconto();
    }

    private void validarPremium() {
        if (nome != null && nome.toLowerCase().contains("premium")) {
            if (preco < 100.0) {
                throw new RuntimeException("Produtos Premium não podem custar menos de R$ 100,00.");
            }
        }
    }

    private void aplicarDesconto() {
        precoFinal = preco;

        if (estoque != null && estoque >= 50) {
            precoFinal = preco - (preco * 0.10);
        }
    }

    // GETTERS E SETTERS

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Integer getEstoque() { return estoque; }
    public void setEstoque(Integer estoque) { this.estoque = estoque; }

    public Double getPreco() { return preco; }
    public void setPreco(Double preco) { this.preco = preco; }

    public Double getPrecoFinal() { return precoFinal; }
    public void setPrecoFinal(Double precoFinal) { this.precoFinal = precoFinal; }
}