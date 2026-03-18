package com.fag.lucasmartins.mvc.model.bo;

public class ProdutoBO {
    private String nome;
    private Double precoOriginal;
    private Integer estoque;
    private Double precoFinal;

    public ProdutoBO(String nome, Double precoOriginal, Integer estoque) {
        this.nome = nome;
        this.precoOriginal = precoOriginal;
        this.estoque = estoque;
        this.precoFinal = precoOriginal;
    }

    public void aplicarRegrasNegocio() throws Exception {
        if (nome != null && nome.toLowerCase().contains("premium") && precoOriginal < 100.0) {
            throw new Exception("Erro: Produtos Premium não podem custar menos de R$ 100,00.");
        }

        
        if (estoque != null && estoque >= 50) {
            this.precoFinal = precoOriginal * 0.90;
        } else {
            this.precoFinal = precoOriginal;
        }
    }

    public String getNome() { return nome; }
    public Double getPrecoOriginal() { return precoOriginal; }
    public Integer getEstoque() { return estoque; }
    public Double getPrecoFinal() { return precoFinal; }
}