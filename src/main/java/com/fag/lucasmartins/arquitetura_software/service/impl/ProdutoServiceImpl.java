package com.fag.lucasmartins.arquitetura_software.service.impl;

import com.fag.lucasmartins.arquitetura_software.model.BO.ProdutoBO;
import com.fag.lucasmartins.arquitetura_software.model.service.ProdutoService;
import com.fag.lucasmartins.arquitetura_software.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public ProdutoBO cadastrarProduto(ProdutoBO produtoBO) {
        produtoBO.validarProdutoPremium();
        produtoBO.aplicarDescontoAtacado();
        return produtoRepository.salvar(produtoBO);
    }
}
