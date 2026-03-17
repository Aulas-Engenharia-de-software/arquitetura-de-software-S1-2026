package com.fag.lucasmartins.arquitetura_software.controller;

import com.fag.lucasmartins.arquitetura_software.model.Produto;
import com.fag.lucasmartins.arquitetura_software.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

// Camada Web (Controller): Focada em lidar puramente com chamadas HTTP e montar respostas.
// Deve se manter cega para regras de negócio ou de persistência em banco de dados.
@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    // Recebe e decodifica a requisição via Payload
    @PostMapping
    public ResponseEntity<Object> cadastrarProduto(@RequestBody Map<String, Object> payload) {
        try {
            // 1. Extração dos dados do JSON web
            String nome = (String) payload.get("nome");
            Integer estoque = (Integer) payload.get("estoque");
            double preco = (double) payload.get("preco");

            Produto produto = new Produto(nome, preco, estoque);
            
            // 2. Transfere a responsabilidade lógica à camada especializada (Service)
            Produto produtoProcessado = produtoService.cadastrarProduto(produto);

            // 3. Montagem da formatação de resposta de Sucesso (HTTP 201 Created)
            Map<String, Object> response = new HashMap<>();
            response.put("mensagem", "Produto cadastrado com sucesso!");
            response.put("nome", produtoProcessado.getNome());
            response.put("estoque", produtoProcessado.getEstoque());
            response.put("preco", produtoProcessado.getPreco());
            response.put("preco_final", produtoProcessado.getPrecoFinal());

            return ResponseEntity.status(HttpStatus.CREATED).body(response);

        } catch (IllegalArgumentException e) {
            // 4a. Responde devidamente se a camada Service barrar a operação por validação (HTTP 400 Bad Request)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            // 4b. Trata de forma genérica falhas catastróficas (HTTP 500 Internal Error)
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao processar requisição: " + e.getMessage());
        }
    }
}