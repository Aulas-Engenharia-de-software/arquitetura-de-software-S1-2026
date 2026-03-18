package com.fag.lucasmartins.mvc.controller.mapper;

import com.fag.lucasmartins.mvc.model.bo.ProdutoBO;
import com.fag.lucasmartins.mvc.view.dto.ProdutoDTO;

public class ProdutoDTOMapper {
    public static ProdutoBO toBO(ProdutoDTO dto) {
        return new ProdutoBO(dto.getNome(), dto.getPreco(), dto.getEstoque());
    }

    public static ProdutoDTO toDTO(ProdutoBO bo) {
        ProdutoDTO dto = new ProdutoDTO();
        dto.setNome(bo.getNome());
        dto.setPreco(bo.getPrecoOriginal());
        dto.setEstoque(bo.getEstoque());
        dto.setPrecoFinal(bo.getPrecoFinal());
        return dto;
    }
}