package com.fag.lucasmartins.arquitetura_software.service.imp;

import com.fag.lucasmartins.arquitetura_software.model.bo.ProdutoBO;
import com.fag.lucasmartins.arquitetura_software.repository.ProdutoRepository;
import com.fag.lucasmartins.arquitetura_software.service.ProdutoService;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServiceImp implements ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoServiceImp(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }


    @Override
    public ProdutoBO criarProduto(ProdutoBO produtoBO) {
        produtoBO.calculaPrecoFinal();
        return produtoRepository.salvar(produtoBO);
    }
}
