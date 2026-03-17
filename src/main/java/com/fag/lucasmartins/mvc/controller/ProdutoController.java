package com.fag.lucasmartins.mvc.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fag.lucasmartins.mvc.model.service.IProdutoService;
import com.fag.lucasmartins.mvc.view.dto.ProdutoDTO;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private final IProdutoService produtoService;

    public ProdutoController(IProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> criarProduto(@Valid @RequestBody ProdutoDTO dto) {
        ProdutoDTO produtoCriadoDTO = produtoService.criarProduto(dto);
        return ResponseEntity.status(201).body(produtoCriadoDTO);
    }
}
