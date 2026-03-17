package com.fag.lucasmartins.arquitetura_software.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.fag.lucasmartins.arquitetura_software.model.Produto;

@Repository
public class ProdutoRepository implements IProdutoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void salvar(Produto produto, double precoFinal) {
        String sql = "INSERT INTO produto (nome, preco, preco_final, estoque) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                produto.getNome(),
                produto.getPreco(),
                precoFinal,
                produto.getEstoque());
    }
}