package com.fag.lucasmartins.arquitetura_software.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;
import com.fag.lucasmartins.arquitetura_software.dto.ProdutoRequestDTO;
import com.fag.lucasmartins.arquitetura_software.service.ProdutoService;
import com.fag.lucasmartins.arquitetura_software.domain.Produto;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Object> cadastrarProduto(@RequestBody ProdutoRequestDTO payload) {
        try {
            Produto produtoProcessado = produtoService.processarCadastro(payload);
                  
            Map<String, Object> response = new HashMap<>();
            response.put("mensagem", "Produto cadastrado com sucesso!");
            response.put("nome", produtoProcessado.getNome());
            response.put("estoque", produtoProcessado.getEstoque());
            response.put("preco", produtoProcessado.getPreco());
            response.put("preco_final", produtoProcessado.getPrecoFinal());

            

            return ResponseEntity.status(HttpStatus.CREATED).body(response);

        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao processar requisição: " + e.getMessage());
        }
    }
}