package com.fag.lucasmartins.arquitetura_software.service.impl;

import org.springframework.stereotype.Service;

import com.fag.lucasmartins.arquitetura_software.service.ProdutoService;
import com.fag.lucasmartins.arquitetura_software.repository.ProdutoRepository;
import com.fag.lucasmartins.arquitetura_software.dto.ProdutoRequestDTO;
import com.fag.lucasmartins.arquitetura_software.dto.ProdutoResponseDTO;
import com.fag.lucasmartins.arquitetura_software.domain.Produto;
import com.fag.lucasmartins.arquitetura_software.mapper.ProdutoMapper;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoServiceImpl(ProdutoRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProdutoResponseDTO cadastrarProduto(ProdutoRequestDTO dto) {

        Produto produto = ProdutoMapper.toDomain(dto);

        produto.aplicarRegras();

        repository.salvar(produto);

        return ProdutoMapper.toResponse(produto);
    }
}