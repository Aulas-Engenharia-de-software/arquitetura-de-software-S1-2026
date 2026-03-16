package com.fag.lucasmartins.arquitetura_software.model.repository.impl;

import com.fag.lucasmartins.arquitetura_software.model.bo.ProdutoBO;
import com.fag.lucasmartins.arquitetura_software.model.repository.ProdutoRepository;
import com.fag.lucasmartins.arquitetura_software.model.repository.entity.ProdutoEntity;
import com.fag.lucasmartins.arquitetura_software.model.repository.jpa.ProdutoJpaRepository;
import com.fag.lucasmartins.arquitetura_software.model.repository.mapper.ProdutoEntityMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProdutoRepositoryImpl implements ProdutoRepository {

    private final ProdutoJpaRepository jpaRepository;

    public ProdutoRepositoryImpl(ProdutoJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public ProdutoBO criarProduto(ProdutoBO bo) {
        ProdutoEntity entity = ProdutoEntityMapper.toEntity(bo);

        ProdutoEntity produtoCriado = jpaRepository.save(entity);

        return ProdutoEntityMapper.toBo(produtoCriado);
    }

    @Override
    public ProdutoBO comprarProduto(ProdutoBO bo) {
        return bo;
    }

    @Override
    public ProdutoBO buscarPorId(Long id) {
        Optional<ProdutoEntity> produto = jpaRepository.findById(id);

        if (produto.isEmpty()) {
            throw new IllegalArgumentException("Produto não encontrado!");
        }

        return ProdutoEntityMapper.toBo(produto.get());
    }
}