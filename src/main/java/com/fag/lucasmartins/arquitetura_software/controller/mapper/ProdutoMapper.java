package com.fag.lucasmartins.arquitetura_software.controller.mapper;

import com.fag.lucasmartins.arquitetura_software.model.bo.ProdutoBO;
import com.fag.lucasmartins.arquitetura_software.view.dto.ProdutoRequest;
import com.fag.lucasmartins.arquitetura_software.view.dto.ProdutoResponse;

public class ProdutoMapper {

    private ProdutoMapper() {
    }

    public static ProdutoBO toProdutoBO(ProdutoRequest produtoRequest) {
        return ProdutoBO.builder()
                .nome(produtoRequest.getNome())
                .estoque(produtoRequest.getEstoque())
                .preco(produtoRequest.getPreco())
                .precoFinal(produtoRequest.getPreco())
                .build();
    }

    public static ProdutoResponse toProdutoResponse(String mensagem, ProdutoBO produtoBO) {
        return ProdutoResponse.builder()
                .mensagem(mensagem)
                .nome(produtoBO.getNome())
                .estoque(produtoBO.getEstoque())
                .preco(produtoBO.getPreco())
                .precoFinal(produtoBO.getPrecoFinal())
                .build();
    }
}
