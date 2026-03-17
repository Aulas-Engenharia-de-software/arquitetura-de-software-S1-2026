package com.fag.lucasmartins.arquitetura_software.model.repository;

import com.fag.lucasmartins.arquitetura_software.model.bo.ProdutoBO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<ProdutoBO, Long> {
}
