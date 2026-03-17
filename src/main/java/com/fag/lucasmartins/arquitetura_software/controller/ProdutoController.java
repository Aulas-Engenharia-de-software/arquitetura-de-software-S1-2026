package com.fag.lucasmartins.arquitetura_software.controller;

import com.fag.lucasmartins.arquitetura_software.dto.ProdutoRequest;
import com.fag.lucasmartins.arquitetura_software.dto.ProdutoResponse;
import com.fag.lucasmartins.arquitetura_software.service.ProdutoService;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<Object> cadastrarProduto(@RequestBody ProdutoRequest request) {
        try {
            ProdutoResponse response = produtoService.cadastrarProduto(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao processar requisição: " + e.getMessage());
        }
    }
}