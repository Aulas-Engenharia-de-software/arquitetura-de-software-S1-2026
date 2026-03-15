package com.fag.lucasmartins.arquitetura_software.model.BO;

public class ProdutoBO {

    private Long id;
    private String nome;
    private Integer estoque;
    private Double preco;
    private Double precoFinal;

    public ProdutoBO() {}

    public ProdutoBO(Long id, String nome, Integer estoque, Double preco) {
        this.id = id;
        this.nome = nome;
        this.estoque = estoque;
        this.preco = preco;
        this.precoFinal = preco;
    }

    // Regra 1 — Modelo de domínio rico: valida regra de produto Premium
    public void validarProdutoPremium() {
        if (this.nome != null && this.nome.toLowerCase().contains("premium")) {
            if (this.preco < 100.0) {
                throw new IllegalArgumentException("Produtos Premium não podem custar menos de R$ 100,00.");
            }
        }
    }

    // Regra 2 — Modelo de domínio rico: aplica desconto de atacado
    public void aplicarDescontoAtacado() {
        this.precoFinal = this.preco;
        if (this.estoque != null && this.estoque >= 50) {
            this.precoFinal = this.preco - (this.preco * 0.10);
        }
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Integer getEstoque() { return estoque; }
    public void setEstoque(Integer estoque) { this.estoque = estoque; }

    public Double getPreco() { return preco; }
    public void setPreco(Double preco) { this.preco = preco; }

    public Double getPrecoFinal() { return precoFinal; }
    public void setPrecoFinal(Double precoFinal) { this.precoFinal = precoFinal; }
}
