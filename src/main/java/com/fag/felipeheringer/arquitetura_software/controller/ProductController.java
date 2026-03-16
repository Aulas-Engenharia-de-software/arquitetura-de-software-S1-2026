package com.fag.felipeheringer.arquitetura_software.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fag.felipeheringer.arquitetura_software.controller.mapper.ProductDTOMapper;
import com.fag.felipeheringer.arquitetura_software.model.bo.ProductBO;
import com.fag.felipeheringer.arquitetura_software.model.service.ProductService;
import com.fag.felipeheringer.arquitetura_software.view.dto.ProductDTO;
import com.fag.felipeheringer.arquitetura_software.view.dto.response.ProductResponseDTO;

@RestController
@RequestMapping("api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Object> cadastrarProduto(@RequestBody ProductDTO dto) {
        try {

            ProductBO productBO = ProductDTOMapper.toBo(dto);

            ProductBO productSaved = productService.create(productBO);

            ProductResponseDTO response = ProductDTOMapper.toResponseDto(productSaved);;

            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao processar requisição: " + e.getMessage());
        }
    }
}