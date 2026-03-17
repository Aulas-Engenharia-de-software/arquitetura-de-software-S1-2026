package com.fag.lucasmartins.arquitetura_software.service;

import com.fag.lucasmartins.arquitetura_software.model.Produto;
import com.fag.lucasmartins.arquitetura_software.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Camada de Negócio (Service): Concentra toda a inteligência e regras de negócio da aplicação.
// Não conhece nada sobre HTTP, JSONs ou SQL.
@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    // Executa as validações de negócio antes de delegar a persistência ao Repository.
    public Produto cadastrarProduto(Produto produto) throws IllegalArgumentException {
        
        // Validação de negócio: Produtos Premium
        if (produto.getNome() != null && produto.getNome().toLowerCase().contains("premium")) {
            if (produto.getPreco() < 100.0) {
                throw new IllegalArgumentException("Erro: Produtos Premium não podem custar menos de R$ 100,00.");
            }
        }

        // Regra de precificação: Desconto baseado na quantidade em estoque
        double precoFinal = produto.getPreco();
        if (produto.getEstoque() != null && produto.getEstoque() >= 50) {
            precoFinal = produto.getPreco() - (produto.getPreco() * 0.10);
        }
        produto.setPrecoFinal(precoFinal);

        // Após aplicar e validar todas as regras, acionamos a camada que salva os dados
        produtoRepository.salvar(produto);

        return produto;
    }
}
