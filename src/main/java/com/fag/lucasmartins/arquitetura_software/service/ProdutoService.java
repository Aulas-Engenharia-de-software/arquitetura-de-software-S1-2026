package main.java.com.fag.lucasmartins.arquitetura_software.service;

import model.Produto;
import org.springframework.stereotype.Service;
import repository.ProdutoRepository;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public Produto cadastrar(String nome, Integer estoque, Double preco) {
        Produto produto = new Produto(nome, estoque, preco);

        repository.salvar(
                produto.getNome(),
                produto.getPreco(),
                produto.getPrecoFinal(),
                produto.getEstoque()
        );

        return produto;
    }
}