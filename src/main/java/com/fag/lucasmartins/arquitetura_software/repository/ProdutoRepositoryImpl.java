package com.fag.lucasmartins.arquitetura_software.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.fag.lucasmartins.arquitetura_software.domain.Produto;

@Repository 
public class ProdutoRepositoryImpl implements ProdutoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void salvar(Produto produto) {
        String sqlInsertPedido = "INSERT INTO produto (nome, preco, preco_final, estoque) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sqlInsertPedido, produto.getNome(), produto.getPreco(), produto.getPrecoFinal(), produto.getEstoque());
    }
}