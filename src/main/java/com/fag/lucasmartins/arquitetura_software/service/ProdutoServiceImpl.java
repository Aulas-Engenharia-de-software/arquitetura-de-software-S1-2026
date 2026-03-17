package com.fag.lucasmartins.arquitetura_software.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fag.lucasmartins.arquitetura_software.domain.Produto;
import com.fag.lucasmartins.arquitetura_software.dto.ProdutoRequestDTO;
import com.fag.lucasmartins.arquitetura_software.repository.ProdutoRepository;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    @Override
    public Produto processarCadastro(ProdutoRequestDTO dto) {
        Produto produto = new Produto(dto.getNome(), dto.getEstoque(), dto.getPreco());
        
        produto.validarRegras();
        produto.calcularPrecoFinal();
        
        repository.salvar(produto);

        return produto;
    }
}