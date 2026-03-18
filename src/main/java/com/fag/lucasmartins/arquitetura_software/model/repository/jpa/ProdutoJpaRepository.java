package com.fag.lucasmartins.arquitetura_software.model.repository.jpa;

import org.springframework.stereotype.Repository;

import com.fag.lucasmartins.arquitetura_software.model.repository.entity.ProdutoEntity;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface ProdutoJpaRepository extends JpaRepository<ProdutoEntity, Long> {
}