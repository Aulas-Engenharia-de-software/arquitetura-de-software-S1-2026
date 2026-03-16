package com.fag.lucasmartins.arquitetura_software.model.repository.impl;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.fag.lucasmartins.arquitetura_software.model.bo.ProdutoBO;
import com.fag.lucasmartins.arquitetura_software.model.repository.ProdutoRepository;
import com.fag.lucasmartins.arquitetura_software.model.repository.entity.ProdutoEntity;
import com.fag.lucasmartins.arquitetura_software.model.repository.jpa.ProdutoJpaRepository;
import com.fag.lucasmartins.arquitetura_software.model.repository.mapper.ProdutoEntityMapper;

@Component
public class ProdutoRepositoryImpl implements ProdutoRepository {

    private final ProdutoJpaRepository jpaRepository;

    public ProdutoRepositoryImpl(ProdutoJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public ProdutoBO salvar(ProdutoBO produto) {
        ProdutoEntity entity = ProdutoEntityMapper.toEntity(produto);
        ProdutoEntity savedEntity = jpaRepository.save(entity);
        return ProdutoEntityMapper.toBO(savedEntity);
    }

    @Override
    public ProdutoBO buscarPorId(Long Id) {
        Optional<ProdutoEntity> entity = jpaRepository.findById(Id);
        
        if (entity.isEmpty()) {
            throw new RuntimeException("Produto não encontrado");
        }

        return ProdutoEntityMapper.toBO(entity.get());
    }

}