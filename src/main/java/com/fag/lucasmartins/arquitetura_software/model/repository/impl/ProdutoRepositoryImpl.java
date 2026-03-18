package com.fag.lucasmartins.arquitetura_software.model.repository.impl;

import org.springframework.stereotype.Repository;

import com.fag.lucasmartins.arquitetura_software.model.bo.ProdutoBo;
import com.fag.lucasmartins.arquitetura_software.model.repository.ProdutoRepository;
import com.fag.lucasmartins.arquitetura_software.model.repository.entity.ProdutoEntity;
import com.fag.lucasmartins.arquitetura_software.model.repository.jpa.ProdutoJpaRepository;
import com.fag.lucasmartins.arquitetura_software.model.repository.mapper.ProdutoEntityMapper;

@Repository
public class ProdutoRepositoryImpl implements ProdutoRepository{

    private final ProdutoJpaRepository jpaRepository;

    public ProdutoRepositoryImpl(ProdutoJpaRepository jpaRepository){
        this.jpaRepository = jpaRepository;
    }

    @Override
    public ProdutoBo salvar(ProdutoBo bo) {
        ProdutoEntity produtoEntity = ProdutoEntityMapper.toEntity(bo);
        produtoEntity = jpaRepository.save(produtoEntity);
        return ProdutoEntityMapper.toBo(produtoEntity);
    }
}
