package com.fag.lucasmartins.arquitetura_software.model.repository;

import com.fag.lucasmartins.arquitetura_software.model.bo.ProdutoBO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProdutoRepository {

    private final JdbcTemplate jdbcTemplate;

    public ProdutoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void salvar(ProdutoBO produto) {

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