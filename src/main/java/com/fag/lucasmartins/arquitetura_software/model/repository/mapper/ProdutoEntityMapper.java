package com.fag.lucasmartins.arquitetura_software.model.repository.mapper;

import com.fag.lucasmartins.arquitetura_software.model.bo.ProdutoBo;
import com.fag.lucasmartins.arquitetura_software.model.repository.entity.ProdutoEntity;

public class ProdutoEntityMapper {

    public ProdutoEntityMapper() {
    }

    public static ProdutoEntity toEntity(ProdutoBo bo){
        ProdutoEntity entity = new ProdutoEntity();
        entity.setId(bo.getId());
        entity.setNome(bo.getNome());
        entity.setPreco(bo.getPreco());
        entity.setEstoque(bo.getEstoque());
        entity.setPrecoFinal(bo.getPrecoFinal());
        return entity;

    }

    public static ProdutoBo toBo(ProdutoEntity entity){
        ProdutoBo bo = new ProdutoBo(); 
        bo.setId(entity.getId());
        bo.setNome(entity.getNome());
        bo.setEstoque(entity.getEstoque());
        bo.setPreco(entity.getPreco());
        bo.setPrecoFinal(entity.getPrecoFinal());
        return bo;   
    }

}
