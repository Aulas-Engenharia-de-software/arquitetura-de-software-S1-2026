package com.fag.lucasmartins.arquitetura_software.mapper;

import com.fag.lucasmartins.arquitetura_software.domain.Produto;
import com.fag.lucasmartins.arquitetura_software.dto.ProdutoRequestDTO;
import com.fag.lucasmartins.arquitetura_software.dto.ProdutoResponseDTO;

public class ProdutoMapper {

    public static Produto toDomain(ProdutoRequestDTO dto) {
        Produto produto = new Produto();
        produto.setNome(dto.getNome());
        produto.setPreco(dto.getPreco());
        produto.setEstoque(dto.getEstoque());
        return produto;
    }

    public static ProdutoResponseDTO toResponse(Produto produto) {
        ProdutoResponseDTO dto = new ProdutoResponseDTO();
        dto.setNome(produto.getNome());
        dto.setPreco(produto.getPreco());
        dto.setEstoque(produto.getEstoque());
        dto.setPrecoFinal(produto.getPrecoFinal());
        return dto;
    }
}