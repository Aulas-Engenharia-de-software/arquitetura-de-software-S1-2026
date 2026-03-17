package com.fag.lucasmartins.arquitetura_software.dto;

public class ProdutoResponseDTO {
    private String mensagem;
    private String nome;
    private Double preco;
    private Double precoFinal;
    private Integer estoque;

    public ProdutoResponseDTO(String mensagem, String nome, Double preco, Double precoFinal, Integer estoque) {
        this.mensagem = mensagem;
        this.nome = nome;
        this.preco = preco;
        this.precoFinal = precoFinal;
        this.estoque = estoque;
    }
    
    public String getMensagem() { return mensagem; }
    public String getNome() { return nome; }
    public Double getPreco() { return preco; }
    public Double getPrecoFinal() { return precoFinal; }
    public Integer getEstoque() { return estoque; }
}