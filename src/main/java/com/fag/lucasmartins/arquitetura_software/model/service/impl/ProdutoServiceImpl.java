package com.fag.lucasmartins.arquitetura_software.model.service.impl;

import com.fag.lucasmartins.arquitetura_software.model.bo.ProdutoBO;
import com.fag.lucasmartins.arquitetura_software.model.repository.ProdutoRepository;
import com.fag.lucasmartins.arquitetura_software.model.service.ProdutoService;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServiceImpl implements ProdutoService{

    private final ProdutoRepository produtoRepository;

    public ProdutoServiceImpl(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }

    @Override
    public ProdutoBO criarProduto(ProdutoBO produtoBO){

        produtoBO.verificarProdutoPremium();

        double precoComDesconto = produtoBO.calcularPrecoFinal();
        produtoBO.setPrecoFinal(precoComDesconto);


        return produtoRepository.salvar(produtoBO);
    }
}
