package com.fag.lucasmartins.arquitetura_software.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.fag.lucasmartins.arquitetura_software.model.Produto;

@Repository
public class ProdutoRepository {

    private final JdbcTemplate jdbcTemplate;

    public ProdutoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void salvar(Produto produto) {
        String sql = "INSERT INTO produto (nome, preco, preco_final, estoque) VALUES (?, ?, ?, ?)";

        jdbcTemplate.update(
            sql,
            produto.getNome(),
            produto.getPreco(),
            produto.getPrecoFinal(),
            produto.getEstoque()
        );
    }
}