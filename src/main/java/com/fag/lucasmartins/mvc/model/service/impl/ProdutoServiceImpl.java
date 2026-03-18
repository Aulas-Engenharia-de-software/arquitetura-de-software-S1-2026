package com.fag.lucasmartins.mvc.model.service.impl;

import org.springframework.stereotype.Service;

import com.fag.lucasmartins.mvc.controller.mapper.ProdutoDTOMapper;
import com.fag.lucasmartins.mvc.model.bo.ProdutoBO;
import com.fag.lucasmartins.mvc.model.service.ProdutoService;
import com.fag.lucasmartins.mvc.view.dto.ProdutoDTO;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Override
    public ProdutoDTO criarProduto(ProdutoDTO dto) throws Exception {
        ProdutoBO bo = ProdutoDTOMapper.toBO(dto);
        bo.aplicarRegrasNegocio();
        return ProdutoDTOMapper.toDTO(bo);
    }
}