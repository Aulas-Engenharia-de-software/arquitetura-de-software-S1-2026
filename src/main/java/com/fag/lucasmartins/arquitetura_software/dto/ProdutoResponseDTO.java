package com.fag.lucasmartins.arquitetura_software.dto;

public class ProdutoResponseDTO {
    private String mensagem;
    private String nome;
    private Integer estoque;
    private double preco;
    private double precoFinal;

    public ProdutoResponseDTO(String mensagem, String nome, Integer estoque, double preco, double precoFinal) {
        this.mensagem = mensagem;
        this.nome = nome;
        this.estoque = estoque;
        this.preco = preco;
        this.precoFinal = precoFinal;
    }

    // Getters...
    public String getMensagem() { return mensagem; }
    public String getNome() { return nome; }
    public Integer getEstoque() { return estoque; }
    public double getPreco() { return preco; }
    public double getPrecoFinal() { return precoFinal; }
}