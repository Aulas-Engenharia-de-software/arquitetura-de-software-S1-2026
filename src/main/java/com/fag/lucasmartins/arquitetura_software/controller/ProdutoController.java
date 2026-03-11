package com.fag.lucasmartins.arquitetura_software.controller;

import com.fag.lucasmartins.arquitetura_software.controller.mapper.ProdutoDTOMapper;
import com.fag.lucasmartins.arquitetura_software.model.bo.ProdutoBO;
import com.fag.lucasmartins.arquitetura_software.model.service.ProdutoService;
import com.fag.lucasmartins.arquitetura_software.view.dto.ProdutoDTO;
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
    public ResponseEntity<ProdutoDTO> cadastrarProduto(@RequestBody ProdutoDTO dto) {

        ProdutoBO produtoBO = ProdutoDTOMapper.toBO(dto);

        ProdutoBO produtoCriado = produtoService.cadastrarProduto(produtoBO);

        ProdutoDTO response = ProdutoDTOMapper.toDTO(produtoCriado);

        return ResponseEntity
                .status(201)
                .body(response);
    }
}