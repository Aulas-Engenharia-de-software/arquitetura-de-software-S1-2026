package com.fag.lucasmartins.arquitetura_software.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProdutoRepository {

    private final JdbcTemplate jdbcTemplate;

    public ProdutoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void salvar(String nome, double preco, double precoFinal, Integer estoque) {
        String sql = "INSERT INTO produto (nome, preco, preco_final, estoque) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, nome, preco, precoFinal, estoque);
    }
}