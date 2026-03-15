package com.fag.lucasmartins.arquitetura_software.view.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ProdutoRequestDTO {

    @NotBlank
    private String nome;

    @NotNull
    @Min(0)
    private Integer estoque;

    @NotNull
    @Min(0)
    private Double preco;

    public ProdutoRequestDTO() {
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

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
