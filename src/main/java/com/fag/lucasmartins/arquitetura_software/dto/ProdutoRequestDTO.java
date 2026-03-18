package com.fag.lucasmartins.arquitetura_software.dto;

import java.math.BigDecimal;

public class ProdutoRequestDTO {
    private String nome;
    private BigDecimal preco;
    private Integer estoque; 


    public String getNome() { 
        return nome; 
    }
    public void setNome(String nome) { 
        this.nome = nome; 
    }

    public BigDecimal getPreco() { 
        return preco; 
    }
    public void setPreco(BigDecimal preco) { 
        this.preco = preco; 
    }

    public Integer getEstoque() { 
        return estoque; 
    }
    public void setEstoque(Integer estoque) { 
        this.estoque = estoque; 
    }
}