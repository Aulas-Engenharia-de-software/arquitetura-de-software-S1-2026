package com.fag.lucasmartins.arquitetura_software.controller;

import com.fag.lucasmartins.arquitetura_software.dto.ProdutoRequestDTO;
import com.fag.lucasmartins.arquitetura_software.dto.ProdutoResponseDTO;
import com.fag.lucasmartins.arquitetura_software.service.ProdutoService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public ResponseEntity<ProdutoResponseDTO> cadastrarProduto(@RequestBody ProdutoRequestDTO dto) {

        ProdutoResponseDTO response = produtoService.criarProduto(dto);

        return ResponseEntity.status(201).body(response);
    }
}