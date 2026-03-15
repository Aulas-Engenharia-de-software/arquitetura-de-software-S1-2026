package com.fag.lucasmartins.arquitetura_software.controller.mapper;

import com.fag.lucasmartins.arquitetura_software.model.bo.ProdutoBO;
import com.fag.lucasmartins.arquitetura_software.view.dto.ProdutoRequestDTO;
import com.fag.lucasmartins.arquitetura_software.view.dto.ProdutoResponseDTO;

public class ProdutoDTOMapper {

    public static ProdutoBO toBo(ProdutoRequestDTO dto) {
        if (dto == null) return null;
        ProdutoBO bo = new ProdutoBO();
        bo.setNome(dto.getNome());
        bo.setEstoque(dto.getEstoque());
        bo.setPreco(dto.getPreco());
        return bo;
    }

    public static ProdutoResponseDTO toDto(ProdutoBO bo) {
        if (bo == null) return null;
        ProdutoResponseDTO dto = new ProdutoResponseDTO();
        dto.setId(bo.getId());
        dto.setNome(bo.getNome());
        dto.setEstoque(bo.getEstoque());
        dto.setPreco(bo.getPreco());
        dto.setPrecoFinal(bo.getPrecoFinal());
        return dto;
    }
}
