package com.fag.lucasmartins.arquitetura_software.repository.impl;

import com.fag.lucasmartins.arquitetura_software.model.BO.ProdutoBO;
import com.fag.lucasmartins.arquitetura_software.repository.ProdutoRepository;
import com.fag.lucasmartins.arquitetura_software.repository.entity.ProdutoEntity;
import com.fag.lucasmartins.arquitetura_software.repository.mapper.ProdutoEntityMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.Statement;

@Component
public class ProdutoRepositoryImpl implements ProdutoRepository {

    private final JdbcTemplate jdbcTemplate;

    public ProdutoRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public ProdutoBO salvar(ProdutoBO bo) {
        ProdutoEntity entity = ProdutoEntityMapper.toEntity(bo);

        String sql = "INSERT INTO produto (nome, preco, preco_final, estoque) VALUES (?, ?, ?, ?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, entity.getNome());
            ps.setDouble(2, entity.getPreco());
            ps.setDouble(3, entity.getPrecoFinal());
            ps.setInt(4, entity.getEstoque());
            return ps;
        }, keyHolder);

        entity.setId(keyHolder.getKey().longValue());

        return ProdutoEntityMapper.toBo(entity);
    }
}
