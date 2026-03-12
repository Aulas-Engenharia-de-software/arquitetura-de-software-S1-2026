package com.fag.lucasmartins.arquitetura_software.repository.mapper;

import com.fag.lucasmartins.arquitetura_software.model.bo.ProdutoBO;
import com.fag.lucasmartins.arquitetura_software.repository.entity.ProdutoEntity;

public class ProdutoEntityMapper {

    public ProdutoEntityMapper() {
    }

    public static ProdutoEntity toEntity(ProdutoBO produtoBO) {
        ProdutoEntity produtoEntity = new ProdutoEntity();
        produtoEntity.setNome(produtoBO.getNome());
        produtoEntity.setEstoque(produtoBO.getEstoque());
        produtoEntity.setPreco(produtoBO.getPreco());
        produtoEntity.setPrecoFinal(produtoBO.getPrecoFinal());
        return produtoEntity;
    }

    public static ProdutoBO toBO(ProdutoEntity produtoEntity) {
        ProdutoBO bo = new ProdutoBO();
        bo.setNome(produtoEntity.getNome());
        bo.setEstoque(produtoEntity.getEstoque());
        bo.setPreco(produtoEntity.getPreco());
        bo.setPrecoFinal(produtoEntity.getPrecoFinal());
        return bo;
    }

}
