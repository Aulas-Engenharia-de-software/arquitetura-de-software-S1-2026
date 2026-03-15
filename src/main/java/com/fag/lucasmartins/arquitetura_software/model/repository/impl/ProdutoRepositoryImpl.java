package com.fag.lucasmartins.arquitetura_software.model.repository.impl;

import com.fag.lucasmartins.arquitetura_software.model.bo.ProdutoBO;
import com.fag.lucasmartins.arquitetura_software.model.repository.ProdutoRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;

@Repository
public class ProdutoRepositoryImpl implements ProdutoRepository {

    private final JdbcTemplate jdbcTemplate;

    public ProdutoRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public ProdutoBO salvar(ProdutoBO produto) {
        final String sql = "INSERT INTO produto (nome, preco, preco_final, estoque) VALUES (?, ?, ?, ?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, produto.getNome());
            ps.setDouble(2, produto.getPreco());
            ps.setDouble(3, produto.getPrecoFinal());
            ps.setInt(4, produto.getEstoque());
            return ps;
        }, keyHolder);

        Number key = keyHolder.getKey();
        if (key != null) {
            produto.setId(key.longValue());
        }

        return produto;
    }
}
