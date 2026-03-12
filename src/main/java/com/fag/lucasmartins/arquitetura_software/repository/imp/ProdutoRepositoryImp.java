package com.fag.lucasmartins.arquitetura_software.repository.imp;

import com.fag.lucasmartins.arquitetura_software.repository.jpa.ProdutoJpaRepository;
import com.fag.lucasmartins.arquitetura_software.model.bo.ProdutoBO;
import com.fag.lucasmartins.arquitetura_software.repository.ProdutoRepository;
import com.fag.lucasmartins.arquitetura_software.repository.entity.ProdutoEntity;
import com.fag.lucasmartins.arquitetura_software.repository.mapper.ProdutoEntityMapper;
import org.springframework.stereotype.Service;

@Service
public class ProdutoRepositoryImp implements ProdutoRepository {

    private final ProdutoJpaRepository produtoJpaRepository;
    public ProdutoRepositoryImp(ProdutoJpaRepository produtoJpaRepository) {
        this.produtoJpaRepository = produtoJpaRepository;
    }

    @Override
    public ProdutoBO salvar(ProdutoBO produtoBO) {
        ProdutoEntity entity = ProdutoEntityMapper.toEntity(produtoBO);
        ProdutoEntity produtoEntity = produtoJpaRepository.save(entity);
        return ProdutoEntityMapper.toBO(produtoEntity);
    }
}
