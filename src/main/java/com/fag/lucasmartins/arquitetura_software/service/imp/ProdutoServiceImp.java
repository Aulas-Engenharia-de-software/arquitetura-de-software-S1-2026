package com.fag.lucasmartins.arquitetura_software.service.imp;

import com.fag.lucasmartins.arquitetura_software.controller.exception.ProdutoPremiumPrecoInvalidoException;
import com.fag.lucasmartins.arquitetura_software.model.bo.ProdutoBO;
import com.fag.lucasmartins.arquitetura_software.repository.ProdutoRepository;
import com.fag.lucasmartins.arquitetura_software.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServiceImp implements ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoServiceImp(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }


    @Override
    public ProdutoBO criarProduto(ProdutoBO produtoBO) {
        produtoBO.calculaPrecoFinal();
        if (produtoBO.getNome() != null && produtoBO.getNome().toLowerCase().contains("premium")) {
                if (produtoBO.getPreco() < 100.0) {
                    throw new ProdutoPremiumPrecoInvalidoException();
                }
            }
        return produtoRepository.salvar(produtoBO);
    }
}
