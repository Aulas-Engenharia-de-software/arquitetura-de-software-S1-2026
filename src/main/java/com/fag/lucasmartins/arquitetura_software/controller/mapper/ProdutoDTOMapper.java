package com.fag.lucasmartins.arquitetura_software.controller.mapper;

import com.fag.lucasmartins.arquitetura_software.model.bo.ProdutoBO;
import com.fag.lucasmartins.arquitetura_software.view.dto.ProdutoDTO;

public class ProdutoDTOMapper {
    
    public static ProdutoBO toBO(ProdutoDTO dto){
        ProdutoBO bo = new ProdutoBO();
        bo.setNome(dto.getNome());
        bo.setPreco(dto.getPreco());
        bo.setEstoque(dto.getEstoque());
        return bo;
    }

    public static ProdutoDTO toDTO(ProdutoBO bo){
        ProdutoDTO dto = new ProdutoDTO();
        dto.setNome(bo.getNome());
        dto.setPreco(bo.getPreco());
        dto.setEstoque(bo.getEstoque());
        return dto;
    }
}
