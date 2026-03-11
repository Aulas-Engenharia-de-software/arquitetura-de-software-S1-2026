package com.fag.lucasmartins.arquitetura_software.model.bo;

public class ProdutoBO {
    
    private String nome; 
    private Double preco;
    private Double precoFinal;
    private Integer estoque;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
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
    public Integer getEstoque() {
        return estoque;
    }
    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }
}
