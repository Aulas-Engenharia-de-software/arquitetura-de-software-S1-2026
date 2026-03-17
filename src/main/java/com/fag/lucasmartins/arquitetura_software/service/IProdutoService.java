package com.fag.lucasmartins.arquitetura_software.service;

import com.fag.lucasmartins.arquitetura_software.dto.ProdutoRequestDTO;
import com.fag.lucasmartins.arquitetura_software.dto.ProdutoResponseDTO;

public interface IProdutoService {
    ProdutoResponseDTO criarProduto(ProdutoRequestDTO dto);
}