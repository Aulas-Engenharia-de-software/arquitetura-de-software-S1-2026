package com.fag.lucasmartins.arquitetura_software.model.bo;

public class ProdutoBO {
    
    private Long id;
    private String nome;
    private Integer estoque;
    private Double preco;
    private Double precoFinal;

    public ProdutoBO() {

    }

    public ProdutoBO(Long id, String nome, Integer estoque, Double preco) {
        this.id = id;
        this.nome = nome;
        this.estoque = estoque;
        this.preco = preco;
        this.precoFinal = preco;
    }

    public ProdutoBO(Long id, String nome, Integer estoque, Double preco, Double precoFinal) {
        this.id = id;
        this.nome = nome;
        this.estoque = estoque;
        this.preco = preco;
        this.precoFinal = precoFinal;
    }

    public void comprarProduto() {
        if (this.estoque > 0) {
            this.estoque--;
            this.precoFinal = this.preco * 0.9; // Aplica desconto de 10%
        }
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Double getPrecoFinal() {
        return precoFinal;
    }

    public void setPrecoFinal(Double precoFinal) {
        this.precoFinal = precoFinal;
    }

}
