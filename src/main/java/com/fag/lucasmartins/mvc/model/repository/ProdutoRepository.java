package com.fag.lucasmartins.mvc.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fag.lucasmartins.mvc.model.repository.entity.ProdutoEntity;

public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {
}