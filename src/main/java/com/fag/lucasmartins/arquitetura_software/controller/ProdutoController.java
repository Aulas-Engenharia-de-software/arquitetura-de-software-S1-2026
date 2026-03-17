package com.fag.lucasmartins.arquitetura_software.controller;

import com.fag.lucasmartins.arquitetura_software.controller.mapper.ProdutoMapper;
import com.fag.lucasmartins.arquitetura_software.exception.BadRequestException;
import com.fag.lucasmartins.arquitetura_software.model.service.impl.ProdutoService;
import com.fag.lucasmartins.arquitetura_software.view.dto.ProdutoRequest;
import com.fag.lucasmartins.arquitetura_software.view.dto.ProdutoResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public ResponseEntity<ProdutoResponse> cadastrarProduto(@RequestBody ProdutoRequest produtoRequest) {

        if (isPremium(produtoRequest) && produtoRequest.getPreco() < 100.0) {
            throw new BadRequestException("Erro: Produtos Premium não podem custar menos de R$ 100,00.");
        }

        var produtoBO = ProdutoMapper.toProdutoBO(produtoRequest);

        var savedProdutoBO = produtoService.cadastrarProduto(produtoBO);

        var produtoResponse = ProdutoMapper.toProdutoResponse("Produto cadastrado com sucesso!", savedProdutoBO);

        return ResponseEntity.status(HttpStatus.CREATED).body(produtoResponse);
    }

    public boolean isPremium(ProdutoRequest produtoRequest) {
        return produtoRequest.getNome() != null && produtoRequest.getNome().toLowerCase().contains("premium");
    }
}