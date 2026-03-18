package com.fag.lucasmartins.arquitetura_software.controller.mapper;

import com.fag.lucasmartins.arquitetura_software.model.bo.ProdutoBo;
import com.fag.lucasmartins.arquitetura_software.view.dto.ProdutoDto;

public class ProdutoDTOMapper {

    private ProdutoDTOMapper(){

    }

    public static ProdutoBo toBo(ProdutoDto dto){
        return new ProdutoBo(dto.getId(), dto.getNome(), dto.getEstoque(), dto.getPreco());
    }

    public static ProdutoDto toDto(ProdutoBo Bo){
        return new ProdutoDto(Bo.getNome(), Bo.getEstoque(), Bo.getPreco());
    }

}

