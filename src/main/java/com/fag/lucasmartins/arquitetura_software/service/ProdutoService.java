package com.fag.lucasmartins.arquitetura_software.service;

import com.fag.lucasmartins.arquitetura_software.bo.ProdutoBO;
import com.fag.lucasmartins.arquitetura_software.model.Produto;
import com.fag.lucasmartins.arquitetura_software.repository.IProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Camada de Negócio (Service): Concentra o fluxo da aplicação e orquestra operações.
@Service
public class ProdutoService implements IProdutoService {

    @Autowired
    private IProdutoRepository produtoRepository;

    @Autowired
    private ProdutoBO produtoBO;

    @Override
    public Produto cadastrarProduto(Produto produto) throws IllegalArgumentException {
        // 1. Aplica as regras de negócio via Business Object (BO)
        Produto produtoProcessado = produtoBO.processarRegrasDeNegocio(produto);

        // 2. Após aplicar e validar todas as regras, acionamos a camada que salva os dados
        produtoRepository.salvar(produtoProcessado);

        return produtoProcessado;
    }
}
