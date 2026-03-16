package com.fag.lucasmartins.arquitetura_software.model.bo;

public class ProdutoBO {
    private Long id;
    private String nome;
    private Integer estoque;
    private double preco;
    private double precoFinal;

    public ProdutoBO() {

    }

    public ProdutoBO(Long id, String nome, Integer estoque, double preco) {
        this.id = id;
        this.nome = nome;
        this.estoque = estoque;
        this.preco = preco;
    }

    public  void validaPremium(ProdutoBO produto) {
        if (produto.nome.toLowerCase().contains("premium") && produto.preco < 100){
            throw new RuntimeException("Produto premium deve ter preço maior ou igual a 100");
        }
    }
    
    public void calculaDescontoEstoque(ProdutoBO produto) {
        if (produto.estoque >= 50) {
            produto.precoFinal = produto.preco - (produto.preco * 0.10); // 10%
        } else {
            produto.precoFinal = produto.preco;
        }
    }

    public void consumirProduto() {
        if (this.estoque <= 0) {
            throw new RuntimeException("Produto sem estoque disponível");
        }
        this.estoque--;
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
