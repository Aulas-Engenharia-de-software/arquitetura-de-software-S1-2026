package com.fag.lucasmartins.arquitetura_software.model.service.impl;

import org.springframework.stereotype.Service;

import com.fag.lucasmartins.arquitetura_software.model.bo.ProdutoBO;
import com.fag.lucasmartins.arquitetura_software.model.repository.ProdutoRepository;
import com.fag.lucasmartins.arquitetura_software.model.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public ProdutoBO criarProduto(ProdutoBO produtoBO) {
        produtoBO.validaPremium(produtoBO);

        produtoBO.calculaDescontoEstoque(produtoBO);

        return produtoRepository.salvar(produtoBO);
    }

    @Override
    public void consumirProduto(Long Id) {
        ProdutoBO produtoBO = produtoRepository.buscarPorId(Id);
        
        produtoBO.consumirProduto();

        produtoRepository.salvar(produtoBO);

    }


}
