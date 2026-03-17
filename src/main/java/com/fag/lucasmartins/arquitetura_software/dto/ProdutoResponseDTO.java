package com.fag.lucasmartins.arquitetura_software.dto;

public class ProdutoResponseDTO extends ProdutoDTO {
    private Long id;
    private String mensagem;
    private double precoFinal;

    public ProdutoResponseDTO() {
        super();
    }

    public ProdutoResponseDTO(String mensagem, String nome, int estoque, double preco, double precoFinal) {
        super(nome, preco, estoque);
        this.mensagem = mensagem;
        this.precoFinal = precoFinal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public double getPrecoFinal() {
        return precoFinal;
    }

    public void setPrecoFinal(double precoFinal) {
        this.precoFinal = precoFinal;
    }
}