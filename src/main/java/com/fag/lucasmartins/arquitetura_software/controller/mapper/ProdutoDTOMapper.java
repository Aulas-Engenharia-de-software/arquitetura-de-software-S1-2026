package com.fag.lucasmartins.arquitetura_software.controller.mapper;

import com.fag.lucasmartins.arquitetura_software.model.bo.ProdutoBO;
import com.fag.lucasmartins.arquitetura_software.view.dto.ProdutoDTO;

public class ProdutoDTOMapper {
    
    private ProdutoDTOMapper() {
    }

    public static ProdutoBO toBo(ProdutoDTO dto) {
        return new ProdutoBO(dto.getId(), dto.getNome(), dto.getEstoque(), dto.getPrecoFinal());
    }

    public static ProdutoDTO toDto(ProdutoBO bo) {
        return new ProdutoDTO(bo.getId(), bo.getNome(), bo.getEstoque(), bo.getPrecoFinal());
    }

}
