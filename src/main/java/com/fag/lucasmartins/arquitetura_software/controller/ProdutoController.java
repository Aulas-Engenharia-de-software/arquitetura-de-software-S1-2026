package com.fag.lucasmartins.arquitetura_software.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fag.lucasmartins.arquitetura_software.controller.mapper.ProdutoDTOMapper;
import com.fag.lucasmartins.arquitetura_software.model.bo.ProdutoBO;
import com.fag.lucasmartins.arquitetura_software.model.service.ProdutoService;
import com.fag.lucasmartins.arquitetura_software.view.dto.ProdutoDTO;

@RestController
@RequestMapping("api/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> criarProduto(@Valid @RequestBody ProdutoDTO produtoDTO) {
        ProdutoBO produtoBO = ProdutoDTOMapper.toBo(produtoDTO);

        ProdutoBO produtoCriadoBO = produtoService.criarProduto(produtoBO);

        ProdutoDTO produtoCriadoDTO = ProdutoDTOMapper.toDto(produtoCriadoBO);

        return ResponseEntity
            .status(201)
            .body(produtoCriadoDTO);
    }

    @PostMapping("/{id}/comprar")
    public ResponseEntity<String> comprarProduto(@PathVariable Long id) {
        produtoService.consumirProduto(id);

        return ResponseEntity.ok("Produto adquirido com sucesso!");

    }
}
