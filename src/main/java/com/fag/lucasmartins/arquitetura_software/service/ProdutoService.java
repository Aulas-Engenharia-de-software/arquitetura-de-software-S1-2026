package com.fag.lucasmartins.arquitetura_software.service;

import org.springframework.stereotype.Service;

import com.fag.lucasmartins.arquitetura_software.dto.ProdutoRequestDTO;

@Service
public class ProdutoService {

    public double calcularPrecoFinal(ProdutoRequestDTO dados) {
        double preco = dados.getPreco().doubleValue();
        double precoFinal = preco;

        
        if (dados.getEstoque() != null && dados.getEstoque() >= 50) {
            precoFinal = preco - (preco * 0.10);
        }
        
        return precoFinal;
    }

    public void validarProdutoPremium(String nome, double preco) throws Exception {
        if (nome != null && nome.toLowerCase().contains("premium")) {
            if (preco < 100.0) {
                throw new Exception("Produtos Premium não podem custar menos de R$ 100,00.");
            }
        }
    }
}