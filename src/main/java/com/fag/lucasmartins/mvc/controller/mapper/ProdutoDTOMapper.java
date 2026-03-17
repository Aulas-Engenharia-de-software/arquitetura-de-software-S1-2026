package com.fag.lucasmartins.mvc.controller.mapper;

import com.fag.lucasmartins.mvc.model.bo.ProdutoBO;
import com.fag.lucasmartins.mvc.view.dto.ProdutoDTO;

public class ProdutoDTOMapper {
   public static ProdutoBO toBO(ProdutoDTO dto) {
      return new ProdutoBO(null, dto.getNome(), dto.getPreco(), dto.getQuantidade());
   }

   public static ProdutoDTO toDTO(ProdutoBO bo) {
      ProdutoDTO dto = new ProdutoDTO();
      dto.setNome(bo.getNome());
      dto.setPreco(bo.getPreco());
      dto.setQuantidade(bo.getQuantidade());
      return dto;
   }
}