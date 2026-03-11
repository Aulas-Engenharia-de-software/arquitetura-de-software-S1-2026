package com.fag.lucasmartins.arquitetura_software.repository;

import com.fag.lucasmartins.arquitetura_software.model.bo.ProdutoBO;
import com.fag.lucasmartins.arquitetura_software.repository.entity.ProdutoEntity;

public interface ProdutoRepository {

    ProdutoBO salvar(ProdutoBO produtoBO);
}
