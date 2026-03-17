package com.fag.lucasmartins.arquitetura_software.service;

import com.fag.lucasmartins.arquitetura_software.domain.Produto;
import com.fag.lucasmartins.arquitetura_software.dto.ProdutoRequestDTO;
import com.fag.lucasmartins.arquitetura_software.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public Produto cadastrar(ProdutoRequestDTO dto) {
        Produto produto = new Produto(
                dto.getNome(),
                dto.getEstoque(),
                dto.getPreco()
        );

        return repository.salvar(produto);
    }
}