package com.fag.lucasmartins.arquitetura_software.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProdutoRepository implements ProdutoRepository {

    private final JdbcTemplate jdbcTemplate;

    public ProdutoRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void salvar(String nome, Double preco, Double precoFinal, Integer estoque) {

        String sql = "INSERT INTO produto (nome, preco, preco_final, estoque) VALUES (?, ?, ?, ?)";

        jdbcTemplate.update(sql, nome, preco, precoFinal, estoque);
    }
}