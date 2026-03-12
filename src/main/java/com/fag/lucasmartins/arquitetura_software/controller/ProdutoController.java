package com.fag.lucasmartins.arquitetura_software.controller;

import com.fag.lucasmartins.arquitetura_software.controller.mapper.ProdutoDTOMapper;
import com.fag.lucasmartins.arquitetura_software.model.bo.ProdutoBO;
import com.fag.lucasmartins.arquitetura_software.service.ProdutoService;
import com.fag.lucasmartins.arquitetura_software.view.dto.ProdutoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public ResponseEntity<Object> cadastrarProduto(@RequestBody ProdutoDTO produtoDTO) {
        ProdutoBO produtoBO = ProdutoDTOMapper.toBO(produtoDTO);
        ProdutoBO produtoCriadoBO = produtoService.criarProduto(produtoBO);
        ProdutoDTO produtoCriadoDTO = ProdutoDTOMapper.toDTO(produtoCriadoBO);
        return  ResponseEntity
                .status(201)
                .body(produtoCriadoDTO);


//            if (nome != null && nome.toLowerCase().contains("premium")) {
//                if (preco < 100.0) {
//                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro: Produtos Premium não podem custar menos de R$ 100,00.");
//                }
//            }
//            double precoFinal = preco;
//            if (estoque != null && estoque >= 50) {
//                precoFinal = preco - (preco * 0.10); // 10%
//            }
//
//            return ResponseEntity.status(HttpStatus.CREATED).body(response);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao processar requisição: " + e.getMessage());
//        }
    }
}