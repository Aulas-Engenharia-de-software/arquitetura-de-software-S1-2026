package com.fag.lucasmartins.arquitetura_software.dto;

public class ProdutoResponseDTO {
    private String mensagem;
    private String nome;
    private double precoFinal;

    public ProdutoResponseDTO(String mensagem, String nome, double precoFinal) {
        this.mensagem = mensagem;
        this.nome = nome;
        this.precoFinal = precoFinal;
    }

    public String getMensagem() {
        return mensagem;
    }

    public String getNome() {
        return nome;
    }

    public double getPrecoFinal() {
        return precoFinal;
    }
}