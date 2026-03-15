package com.fag.lucasmartins.arquitetura_software.model.repository;

import com.fag.lucasmartins.arquitetura_software.model.bo.ProdutoBO;

public interface ProdutoRepository {

    ProdutoBO criarProduto(ProdutoBO bo);

    ProdutoBO comprarProduto(ProdutoBO bo);

    ProdutoBO buscarPorId(Long id);
}
