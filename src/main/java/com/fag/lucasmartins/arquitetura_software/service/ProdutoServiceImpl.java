package com.fag.lucasmartins.arquitetura_software.service;

import com.fag.lucasmartins.arquitetura_software.dto.ProdutoRequestDTO;
import com.fag.lucasmartins.arquitetura_software.dto.ProdutoResponseDTO;
import com.fag.lucasmartins.arquitetura_software.model.Produto;
import com.fag.lucasmartins.arquitetura_software.repository.ProdutoRepository;

import org.springframework.stereotype.Service;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoServiceImpl(ProdutoRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProdutoResponseDTO criarProduto(ProdutoRequestDTO dto) {

        Produto produto = new Produto(dto.getNome(), dto.getEstoque(), dto.getPreco());

        if (produto.isPremium() && produto.getPreco() < 100) {
            throw new RuntimeException("Produtos Premium não podem custar menos de R$100");
        }

        double precoFinal = produto.calcularPrecoFinal();

        repository.salvar(produto.getNome(), produto.getPreco(), precoFinal, produto.getEstoque());

        return new ProdutoResponseDTO(
                "Produto cadastrado com sucesso",
                produto.getNome(),
                produto.getEstoque(),
                produto.getPreco(),
                precoFinal
        );
    }
}