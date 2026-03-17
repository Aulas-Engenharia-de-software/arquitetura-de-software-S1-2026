package com.fag.lucasmartins.arquitetura_software.service;

import com.fag.lucasmartins.arquitetura_software.dto.ProdutoRequestDTO;
import com.fag.lucasmartins.arquitetura_software.dto.ProdutoResponseDTO;
import com.fag.lucasmartins.arquitetura_software.model.Produto;
import com.fag.lucasmartins.arquitetura_software.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    @Override
    public ProdutoResponseDTO cadastrarProduto(ProdutoRequestDTO dto) {
        // 1. Cria a entidade de domínio rico (que se auto-valida)
        Produto produto = new Produto(dto.getNome(), dto.getEstoque(), dto.getPreco());

        // 2. Persiste o produto através da interface (DIP)
        repository.salvar(produto);

        // 3. Monta a resposta
        return new ProdutoResponseDTO(
            "Produto cadastrado com sucesso!",
            produto.getNome(),
            produto.getEstoque(),
            produto.getPreco(),
            produto.getPrecoFinal()
        );
    }
}