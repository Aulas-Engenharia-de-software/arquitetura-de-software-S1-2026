package com.fag.lucasmartins.arquitetura_software.model.repository.mapper;

import com.fag.lucasmartins.arquitetura_software.model.bo.ProdutoBO;
import com.fag.lucasmartins.arquitetura_software.model.repository.entity.ProdutoEntity;

public class ProdutoEntityMapper {
    
    private ProdutoEntityMapper() {
    }

    public static ProdutoEntity toEntity(ProdutoBO bo) {
        ProdutoEntity entity = new ProdutoEntity();
        entity.setId(bo.getId());
        entity.setNome(bo.getNome());
        entity.setEstoque(bo.getEstoque());
        entity.setPreco(bo.getPreco());
        entity.setPrecoFinal(bo.getPrecoFinal());

        return entity;
    }

    public static ProdutoBO toBo(ProdutoEntity entity) {
        ProdutoBO bo = new ProdutoBO();
        bo.setId(entity.getId());
        bo.setNome(entity.getNome());
        bo.setEstoque(entity.getEstoque());
        bo.setPreco(entity.getPreco());
        bo.setPrecoFinal(entity.getPrecoFinal());

        return bo;
    }

}
