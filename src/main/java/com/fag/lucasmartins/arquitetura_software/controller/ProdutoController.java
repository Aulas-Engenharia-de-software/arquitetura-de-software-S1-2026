package com.fag.lucasmartins.arquitetura_software.controller;

import com.fag.lucasmartins.arquitetura_software.dto.ProdutoRequestDTO;
import com.fag.lucasmartins.arquitetura_software.dto.ProdutoResponseDTO;
import com.fag.lucasmartins.arquitetura_software.model.Produto;
import com.fag.lucasmartins.arquitetura_software.service.IProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final IProdutoService produtoService;

    public ProdutoController(IProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public ResponseEntity<ProdutoResponseDTO> obterTodosProdutos() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ProdutoResponseDTO("Sucesso ao buscar produtos.", null, 0, 0.0, 0.0));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ProdutoResponseDTO("Erro ao buscar produtos: " + e.getMessage(), null, 0, 0.0, 0.0));
        }
    }

    @PostMapping
    public ResponseEntity<ProdutoResponseDTO> cadastrarProduto(@RequestBody ProdutoRequestDTO request) {
        try {
            if (request.getNome() == null || request.getNome().isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ProdutoResponseDTO("Erro: Nome obrigatório.", null, 0, 0.0, 0.0));
            }
            if (request.getPreco() <= 0) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ProdutoResponseDTO("Erro: Preço deve ser positivo.", null, 0, 0.0, 0.0));
            }
            if (request.getEstoque() < 0) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ProdutoResponseDTO("Erro: Estoque não pode ser negativo.", null, 0, 0.0, 0.0));
            }

            Produto produto = produtoService.cadastrarProduto(request.getNome(), request.getPreco(), request.getEstoque());

            ProdutoResponseDTO response = new ProdutoResponseDTO(
                "Produto cadastrado com sucesso!",
                produto.getNome(),
                produto.getEstoque(),
                produto.getPreco(),
                produto.getPrecoFinal()
            );

            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ProdutoResponseDTO("Erro: " + e.getMessage(), null, 0, 0.0, 0.0));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ProdutoResponseDTO("Erro ao processar requisição: " + e.getMessage(), null, 0, 0.0, 0.0));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> atualizarProduto(@PathVariable Long id, @RequestBody ProdutoRequestDTO request) {
        try {
            if (request.getNome() == null || request.getNome().isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ProdutoResponseDTO("Erro: Nome obrigatório.", null, 0, 0.0, 0.0));
            }
            if (request.getPreco() <= 0) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ProdutoResponseDTO("Erro: Preço deve ser positivo.", null, 0, 0.0, 0.0));
            }
            if (request.getEstoque() < 0) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ProdutoResponseDTO("Erro: Estoque não pode ser negativo.", null, 0, 0.0, 0.0));
            }

            return ResponseEntity.status(HttpStatus.OK).body(new ProdutoResponseDTO("Produto atualizado com sucesso!", request.getNome(), request.getEstoque(), request.getPreco(), 0.0));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ProdutoResponseDTO("Erro: " + e.getMessage(), null, 0, 0.0, 0.0));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ProdutoResponseDTO("Erro ao atualizar produto: " + e.getMessage(), null, 0, 0.0, 0.0));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> deletarProduto(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ProdutoResponseDTO("Erro ao deletar produto: " + e.getMessage(), null, 0, 0.0, 0.0));
        }
    }
}