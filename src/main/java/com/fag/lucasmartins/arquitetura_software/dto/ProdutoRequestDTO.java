package com.fag.lucasmartins.arquitetura_software.dto;

public class ProdutoRequestDTO {

    private String nome;
    private double preco;
    private int estoque;

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getEstoque() {
        return estoque;
    }
}