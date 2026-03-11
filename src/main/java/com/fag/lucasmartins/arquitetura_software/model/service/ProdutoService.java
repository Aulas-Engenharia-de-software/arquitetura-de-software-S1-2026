package com.fag.lucasmartins.arquitetura_software.model.service;

import com.fag.lucasmartins.arquitetura_software.model.bo.ProdutoBO;
import com.fag.lucasmartins.arquitetura_software.model.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public ProdutoBO cadastrarProduto(ProdutoBO produtoBO) {

        if (produtoBO.getNome().toLowerCase().contains("premium")) {
            if (produtoBO.getPreco() < 100.0) {
                throw new RuntimeException("Produtos Premium não podem custar menos de R$100");
            }
        }

        double precoFinal = produtoBO.getPreco();

        if (produtoBO.getEstoque() >= 50) {
            precoFinal = produtoBO.getPreco() - (produtoBO.getPreco() * 0.10);
        }

        produtoBO.setPrecoFinal(precoFinal);

        repository.salvar(produtoBO);

        return produtoBO;
    }
}