package com.fag.lucasmartins.arquitetura_software.service;

import com.fag.lucasmartins.arquitetura_software.controller.dto.ProdutoRequestDTO;
import com.fag.lucasmartins.arquitetura_software.controller.dto.ProdutoResponseDTO;

public interface ProdutoService {
    ProdutoResponseDTO criarProduto(ProdutoRequestDTO request);
}
