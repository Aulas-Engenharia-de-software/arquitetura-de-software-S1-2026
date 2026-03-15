package com.fag.lucasmartins.arquitetura_software.repository;

import com.fag.lucasmartins.arquitetura_software.model.Produto;

public interface ProdutoRepository {
    Produto save(Produto produto);
}
