package com.fag.lucasmartins.arquitetura_software.controller.dto;

public class ProdutoResponseDTO extends BaseProdutoDTO {
    private Integer id;
    private double precoFinal;
    private String mensagem;

    public ProdutoResponseDTO() {
        super();
    }

    public ProdutoResponseDTO(Integer id, String nome, Integer estoque, double preco, double precoFinal, String mensagem) {
        super(nome, estoque, preco);
        this.id = id;
        this.precoFinal = precoFinal;
        this.mensagem = mensagem;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getPrecoFinal() {
        return precoFinal;
    }

    public void setPrecoFinal(double precoFinal) {
        this.precoFinal = precoFinal;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
