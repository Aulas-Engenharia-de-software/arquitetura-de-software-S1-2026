package com.fag.lucasmartins.arquitetura_software.controller.mapper;

import com.fag.lucasmartins.arquitetura_software.model.bo.ProdutoBO;
import com.fag.lucasmartins.arquitetura_software.view.dto.ProdutoRequest;
import com.fag.lucasmartins.arquitetura_software.view.dto.ProdutoResponse;

public class ProdutoMapper {

    public static ProdutoBO toProdutoBO(ProdutoRequest produtoRequest) {
        return new ProdutoBO(produtoRequest.getNome(), produtoRequest.getEstoque(), produtoRequest.getPreco(), produtoRequest.getPreco());
    }

    public static ProdutoResponse toProdutoResponse(String mensagem, ProdutoBO produtoBO) {
        return new ProdutoResponse(mensagem, produtoBO.getNome(), produtoBO.getEstoque(), produtoBO.getPreco(), produtoBO.getPreco_final());
    }
}
