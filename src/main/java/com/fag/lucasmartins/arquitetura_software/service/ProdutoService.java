package com.fag.lucasmartins.arquitetura_software.service;

import com.fag.lucasmartins.arquitetura_software.domain.Produto;
import com.fag.lucasmartins.arquitetura_software.dto.ProdutoRequest;
import com.fag.lucasmartins.arquitetura_software.dto.ProdutoResponse;
import com.fag.lucasmartins.arquitetura_software.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public ProdutoResponse cadastrarProduto(ProdutoRequest request) {
        Produto produto = new Produto(
                request.getNome(),
                request.getPreco(),
                request.getEstoque());

        produtoRepository.salvar(produto);

        return new ProdutoResponse(
                "Produto cadastrado com sucesso!",
                produto.getNome(),
                produto.getEstoque(),
                produto.getPreco(),
                produto.getPrecoFinal());
    }
}