package com.fag.lucasmartins.arquitetura_software.controller.mapper;

import com.fag.lucasmartins.arquitetura_software.model.BO.ProdutoBO;
import com.fag.lucasmartins.arquitetura_software.view.dto.ProdutoDTO;

public class ProdutoDTOMapper {

    private ProdutoDTOMapper() {}

    public static ProdutoBO toBo(ProdutoDTO dto) {
        return new ProdutoBO(dto.getId(), dto.getNome(), dto.getEstoque(), dto.getPreco());
    }

    public static ProdutoDTO toDto(ProdutoBO bo) {
        return new ProdutoDTO(bo.getId(), bo.getNome(), bo.getEstoque(), bo.getPreco(), bo.getPrecoFinal());
    }
}
