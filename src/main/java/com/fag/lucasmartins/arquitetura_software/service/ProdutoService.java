package com.fag.lucasmartins.arquitetura_software.service;

import com.fag.lucasmartins.arquitetura_software.dto.ProdutoRequestDTO;
import com.fag.lucasmartins.arquitetura_software.model.Produto;
import com.fag.lucasmartins.arquitetura_software.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public Produto cadastrarProduto(ProdutoRequestDTO dto) {

        Produto produto = new Produto(
                dto.getNome(),
                dto.getPreco(),
                dto.getEstoque()
        );

        produto.validarProdutoPremium();
        produto.aplicarDescontoAtacado();

        repository.salvar(produto);

        return produto;
    }
}