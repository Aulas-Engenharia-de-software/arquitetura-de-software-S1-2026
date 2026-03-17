package com.fag.lucasmartins.arquitetura_software.model.bo;

import com.fag.lucasmartins.arquitetura_software.model.Produto;

public class ProdutoBO extends Produto {

    public ProdutoBO(String nome, double preco, int estoque) {
        super(nome, preco, estoque);
        validar();
    }

    public ProdutoBO(Long id, String nome, double preco, int estoque) {
        super(nome, preco, estoque);
        setId(id);
        validar();
    }

    public void validar() {
        if (getNome() == null || getNome().trim().isEmpty()) {
            throw new RuntimeException("Nome do produto é obrigatório.");
        }
        if (getPreco() <= 0) {
            throw new RuntimeException("Preço do produto deve ser maior que zero.");
        }
        if (getEstoque() < 0) {
            throw new RuntimeException("Estoque não pode ser negativo.");
        }
        if (getNome().toLowerCase().contains("premium")) {
            if (getPreco() < 100.0) {
                throw new RuntimeException("Produtos Premium não podem custar menos de R$ 100,00.");
            }
        }
    }
}
