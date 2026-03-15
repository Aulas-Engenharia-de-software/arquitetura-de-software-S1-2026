package com.fag.lucasmartins.arquitetura_software.service;

import com.fag.lucasmartins.arquitetura_software.controller.dto.ProdutoRequestDTO;
import com.fag.lucasmartins.arquitetura_software.controller.dto.ProdutoResponseDTO;
import com.fag.lucasmartins.arquitetura_software.model.Produto;
import com.fag.lucasmartins.arquitetura_software.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public ProdutoResponseDTO criarProduto(ProdutoRequestDTO request) {
        Produto produto = new Produto(request.getNome(), request.getPreco(), request.getEstoque());

        // Regras de negócio no domínio
        produto.validarRegrasDeNegocio();
        produto.aplicarDescontoAtacadoSeAplicavel();

        Produto salvo = produtoRepository.save(produto);

        return new ProdutoResponseDTO(
                salvo.getId(),
                salvo.getNome(),
                salvo.getEstoque(),
                salvo.getPreco(),
                salvo.getPrecoFinal(),
                "Produto cadastrado com sucesso!"
        );
    }
}
