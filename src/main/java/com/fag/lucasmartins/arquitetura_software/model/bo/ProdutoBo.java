package com.fag.lucasmartins.arquitetura_software.model.bo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ProdutoBo {

    private Long id;
    private String nome;
    private int estoque;
    private double preco;
    private double precoFinal;

    public ProdutoBo() {
    }

    public ProdutoBo(long id, String nome, int estoque, double preco) {
        this.id = id;
        this.nome = nome;
        this.estoque = estoque;
        this.preco = preco;
        this.precoFinal = 0;
    }

    public ProdutoBo(long id, String nome, int estoque, double preco, double precoFinal) {
        this.id = id;
        this.nome = nome;
        this.estoque = estoque;
        this.preco = preco;
        this.precoFinal = precoFinal;
    }

    public void validarPrecoProdutoPremium(){
         if (this.nome != null && this.nome.toLowerCase().contains("premium")) {
                if (this.preco < 100.0) {
                    throw new IllegalArgumentException("Erro: Produtos Premium não podem custar menos de R$ 100,00.");
                }
            }
    }

    public void validarDescontoPorQuantidade() {
        if (this.estoque >= 50) {
            this.precoFinal = this.preco - (this.preco * 0.10); // 10% de desconto
        } else {
            this.precoFinal = this.preco; // Sem desconto
        }
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

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
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
