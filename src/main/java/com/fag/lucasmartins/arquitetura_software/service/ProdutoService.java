package com.fag.lucasmartins.arquitetura_software.service;

import com.fag.lucasmartins.arquitetura_software.domain.Produto;
import com.fag.lucasmartins.arquitetura_software.dto.ProdutoRequestDTO;

public interface ProdutoService {
    Produto processarCadastro(ProdutoRequestDTO dto);
}