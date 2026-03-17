package com.fag.lucasmartins.arquitetura_software.view.dto;

public class ProdutoResponse {
    private String mensagem;
    private String nome;
    private Integer estoque;
    private double preco;
    private double preco_final;

    public ProdutoResponse() {
    }

    public ProdutoResponse(String mensagem, String nome, Integer estoque, double preco, double preco_final) {
        this.mensagem = mensagem;
        this.nome = nome;
        this.estoque = estoque;
        this.preco = preco;
        this.preco_final = preco_final;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
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

    public double getPreco_final() {
        return preco_final;
    }

    public void setPreco_final(double preco_final) {
        this.preco_final = preco_final;
    }
}
