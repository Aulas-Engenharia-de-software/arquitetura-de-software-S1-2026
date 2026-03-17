package com.fag.lucasmartins.mvc.model.service.impl;

import com.fag.lucasmartins.mvc.controller.mapper.ProdutoDTOMapper;
import com.fag.lucasmartins.mvc.model.bo.ProdutoBO;
import com.fag.lucasmartins.mvc.model.service.IProdutoService;
import com.fag.lucasmartins.mvc.view.dto.ProdutoDTO;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServiceImpl implements IProdutoService {
    @Override
    public ProdutoDTO criarProduto(ProdutoDTO dto) {
        ProdutoBO bo = ProdutoDTOMapper.toBO(dto);
        bo.aplicarDescontoAtacado();
        return ProdutoDTOMapper.toDTO(bo);
    }
}