package com.fag.lucasmartins.arquitetura_software.repository;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository 
public class ProdutoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void salvar(String nome, BigDecimal preco, double precoFinal, Integer estoque) {
        String sql = "INSERT INTO produto (nome, preco, preco_final, estoque) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, nome, preco, precoFinal, estoque);
    }
}