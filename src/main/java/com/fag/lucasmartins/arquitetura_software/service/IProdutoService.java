package com.fag.lucasmartins.arquitetura_software.service;

import com.fag.lucasmartins.arquitetura_software.model.Produto;

public interface IProdutoService {
    Produto cadastrarProduto(String nome, double preco, int estoque);
}