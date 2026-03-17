package com.fag.lucasmartins.arquitetura_software.repository;

import com.fag.lucasmartins.arquitetura_software.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

// Camada de Persistência (Repository): Responsável exclusiva pelo acesso e manipulação de dados no banco.
// Isolamento total: Qualquer mudança de SQL ou banco de dados afeta apenas esta classe.
@Repository
public class ProdutoRepository implements IProdutoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Transforma o objeto Produto em um registro de banco de dados
    public void salvar(Produto produto) {
        String sqlInsert = "INSERT INTO produto (nome, preco, preco_final, estoque) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sqlInsert, produto.getNome(), produto.getPreco(), produto.getPrecoFinal(), produto.getEstoque());
    }
}
