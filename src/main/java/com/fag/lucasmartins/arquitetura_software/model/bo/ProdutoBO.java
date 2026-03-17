package com.fag.lucasmartins.arquitetura_software.model.bo;

import javax.persistence.*;

@Entity
@Table(name = "produto")
public class ProdutoBO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "estoque")
    private Integer estoque;

    @Column(name = "preco")
    private double preco;

    @Column(name = "preco_final")
    private double preco_final;

    public ProdutoBO() {
    }

    public ProdutoBO(String nome, Integer estoque, double preco, double precoFinal) {
        this.nome = nome;
        this.estoque = estoque;
        this.preco = preco;
        preco_final = precoFinal;
    }

    public void calculateFinalPrice() {
//        double precoFinal = produtoDTO.getPreco();
//        if (produtoDTO.getEstoque() != null && produtoDTO.getEstoque() >= 50) {
//            precoFinal = produtoDTO.getPreco() - (produtoDTO.getPreco() * 0.10); // 10%
//    }
        if (estoque >= 50) {
            preco_final = preco * 0.90;
            return;
        }
        preco_final = preco;
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

    public double getPreco_final() {
        return preco_final;
    }

    public void setPreco_final(double preco_final) {
        this.preco_final = preco_final;
    }
}
