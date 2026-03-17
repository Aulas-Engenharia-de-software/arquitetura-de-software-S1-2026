package com.fag.lucasmartins.arquitetura_software.service;

import com.fag.lucasmartins.arquitetura_software.model.Produto;
import com.fag.lucasmartins.arquitetura_software.dto.ProdutoRequestDTO;
import com.fag.lucasmartins.arquitetura_software.dto.ProdutoResponseDTO;
import com.fag.lucasmartins.arquitetura_software.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public ProdutoResponseDTO cadastrarProduto(ProdutoRequestDTO request) {
        Produto produto = new Produto(request.getNome(), request.getPreco(), request.getEstoque());

        repository.salvar(produto);

        return new ProdutoResponseDTO(
                "Produto cadastrado com sucesso!",
                produto.getNome(),
                produto.getPreco(),
                produto.getPrecoFinal(),
                produto.getEstoque()
        );
    }
}