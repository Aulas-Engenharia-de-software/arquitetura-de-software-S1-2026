package com.fag.lucasmartins.arquitetura_software.repository;

import com.fag.lucasmartins.arquitetura_software.domain.Produto;

public interface ProdutoRepository {
    Produto salvar(Produto produto);
}