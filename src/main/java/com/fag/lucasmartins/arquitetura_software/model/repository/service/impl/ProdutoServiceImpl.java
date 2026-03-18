package com.fag.lucasmartins.arquitetura_software.model.repository.service.impl;

import org.springframework.stereotype.Service;

import com.fag.lucasmartins.arquitetura_software.model.bo.ProdutoBo;
import com.fag.lucasmartins.arquitetura_software.model.repository.ProdutoRepository;
import com.fag.lucasmartins.arquitetura_software.model.repository.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService {
        
    private final ProdutoRepository produtoRepository;
    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public ProdutoBo criarProduto(ProdutoBo produtoBo) {

        return produtoRepository.salvar(produtoBo);

    }
}
