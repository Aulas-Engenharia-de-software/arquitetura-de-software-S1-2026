package com.fag.lucasmartins.arquitetura_software.model.service;

import com.fag.lucasmartins.arquitetura_software.model.bo.ProdutoBO;
import com.fag.lucasmartins.arquitetura_software.model.repository.ProdutoRepository;
import com.fag.lucasmartins.arquitetura_software.model.service.impl.ProdutoService;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public ProdutoBO cadastrarProduto(ProdutoBO produtoBO) {
        produtoBO.calculateFinalPrice();

//        String sqlInsertPedido = "INSERT INTO produto (nome, preco, preco_final, estoque) VALUES (?, ?, ?, ?)";
//        jdbcTemplate.update(sqlInsertPedido, produtoDTO.getNome(), produtoDTO.getPreco(), precoFinal, produtoDTO.getEstoque());

         return produtoRepository.save(produtoBO);

//        Map<String, Object> response = new HashMap<>();
//        response.put("mensagem", "Produto cadastrado com sucesso!");
//        response.put("nome", produtoRequest.getNome());
//        response.put("estoque", produtoRequest.getEstoque());
//        response.put("preco", produtoRequest.getPreco());
//        response.put("preco_final", precoFinal);
    }
}
