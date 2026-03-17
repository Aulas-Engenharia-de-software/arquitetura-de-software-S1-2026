package com.fag.lucasmartins.arquitetura_software.service;
import org.springframework.stereotype.Service;
import com.fag.lucasmartins.arquitetura_software.dto.ProdutoRequestDTO;
import com.fag.lucasmartins.arquitetura_software.model.Produto;
import com.fag.lucasmartins.arquitetura_software.repository.ProdutoRepository;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

public void cadastrarProduto(ProdutoRequestDTO dto) {

    Produto produto = new Produto(
        dto.getNome(),
        dto.getPreco(),
        dto.getEstoque()
    );

    produto.aplicarRegras();

    repository.salvar(produto);
}
}