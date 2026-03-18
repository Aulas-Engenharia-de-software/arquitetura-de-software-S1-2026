package com.fag.lucasmartins.mvc.model.service;

import com.fag.lucasmartins.mvc.view.dto.ProdutoDTO;

public interface ProdutoService {
    ProdutoDTO criarProduto(ProdutoDTO dto) throws Exception;
}