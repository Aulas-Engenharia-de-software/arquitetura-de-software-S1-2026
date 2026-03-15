package com.fag.lucasmartins.arquitetura_software.model.bo;

public class ProdutoBO {
    private Long id;
    private String nome;
    private Integer estoque;
    private double preco;
    private double precoFinal;

    public ProdutoBO() {
    }

    public ProdutoBO(String nome, Integer estoque, double preco) {
        this.nome = nome;
        this.estoque = estoque;
        this.preco = preco;
    }

    public ProdutoBO(Long id, String nome, Integer estoque, double preco, double precoFinal) {
        this.id = id;
        this.nome = nome;
        this.estoque = estoque;
        this.preco = preco;
        this.precoFinal = precoFinal;
    }

    public void verificarProdutoPremium(){
        if (this.nome != null && this.nome.toLowerCase().contains("premium") && this.preco < 100.0) {
            throw new IllegalArgumentException("Erro: Produtos Premium não podem custar menos de R$ 100,00.");
        }
    }

    public double calcularPrecoFinal() {
        if (this.estoque != null && this.estoque >= 50) {
            return this.preco - (this.preco * 0.10); // Aplica 10% de desconto
        }
        return this.preco; // Sem desconto
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
