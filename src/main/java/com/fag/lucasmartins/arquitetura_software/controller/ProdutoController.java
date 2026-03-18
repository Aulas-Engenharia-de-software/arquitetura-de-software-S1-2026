package com.fag.lucasmartins.arquitetura_software.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fag.lucasmartins.arquitetura_software.controller.mapper.ProdutoDTOMapper;
import com.fag.lucasmartins.arquitetura_software.model.bo.ProdutoBo;
import com.fag.lucasmartins.arquitetura_software.model.repository.service.ProdutoService;
import com.fag.lucasmartins.arquitetura_software.view.dto.ProdutoDto;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public ResponseEntity<ProdutoDto> cadastrarProduto(@Valid @RequestBody ProdutoDto dto) {
        ProdutoBo produtoBo = ProdutoDTOMapper.toBo(dto);

        ProdutoBo produtoCriadoBo = produtoService.criarProduto(produtoBo);

        ProdutoDto produtoCriadoDto = ProdutoDTOMapper.toDto(produtoCriadoBo);

        return ResponseEntity
                .status(201)
                .body(produtoCriadoDto);

    }

}