package com.fag.lucasmartins.mvc.model.repository;

import com.fag.lucasmartins.mvc.model.repository.entity.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProdutoRepository extends JpaRepository<ProdutoEntity, Long> {
}