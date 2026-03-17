package com.fag.lucasmartins.arquitetura_software.bo;

import com.fag.lucasmartins.arquitetura_software.model.Produto;
import org.springframework.stereotype.Component;

@Component
public class ProdutoBO {

    // Regras de negócio centralizadas no Business Object (BO)
    public Produto processarRegrasDeNegocio(Produto produto) {
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

        return produto;
    }
}