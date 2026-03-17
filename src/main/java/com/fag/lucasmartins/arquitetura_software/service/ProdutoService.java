package com.fag.lucasmartins.arquitetura_software.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fag.lucasmartins.arquitetura_software.dto.*;
import com.fag.lucasmartins.arquitetura_software.model.Produto;
import com.fag.lucasmartins.arquitetura_software.repository.IProdutoRepository;

@Service
public class ProdutoService implements IProdutoService {

    private final IProdutoRepository repository;

    @Autowired
    public ProdutoService(IProdutoRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProdutoResponseDTO criarProduto(ProdutoRequestDTO dto) {
        Produto produto = new Produto(dto.getNome(), dto.getPreco(), dto.getEstoque());
        double precoFinal = produto.calcularPrecoFinal();

        repository.salvar(produto, precoFinal);

        return new ProdutoResponseDTO("Produto cadastrado com sucesso!", produto.getNome(), precoFinal);
    }
}