package com.fag.lucasmartins.arquitetura_software.model.bo;

public class ProdutoBO {

    private Long id;
    private String nome;
    private Integer estoque;
    private Double preco;
    private Double precoFinal;

    public ProdutoBO() {
    }

    public ProdutoBO(Long id, String nome, Integer estoque, Double preco) {
        this.id = id;
        this.nome = nome;
        this.estoque = estoque;
        this.preco = preco;
        this.precoFinal = preco;
    }

    public void aplicarRegrasComerciais() {
        validarPremium();
        calcularPrecoFinal();
    }

    private void validarPremium() {
        if (this.nome != null && this.nome.toLowerCase().contains("premium")) {
            if (this.preco == null || this.preco < 100.0) {
                throw new IllegalArgumentException("Produtos Premium não podem custar menos de R$ 100,00.");
            }
        }
    }

    private void calcularPrecoFinal() {
        if (this.preco == null) {
            this.precoFinal = null;
            return;
        }
        double valor = this.preco;
        if (this.estoque != null && this.estoque >= 50) {
            valor = valor - (valor * 0.10); // desconto de 10% para atacado
        }
        this.precoFinal = valor;
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
}
