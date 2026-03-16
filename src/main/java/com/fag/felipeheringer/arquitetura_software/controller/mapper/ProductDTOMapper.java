package com.fag.felipeheringer.arquitetura_software.controller.mapper;

import com.fag.felipeheringer.arquitetura_software.model.bo.ProductBO;
import com.fag.felipeheringer.arquitetura_software.view.dto.ProductDTO;
import com.fag.felipeheringer.arquitetura_software.view.dto.response.ProductResponseDTO;

public class ProductDTOMapper{

    public static ProductBO toBo (ProductDTO dto) {
        return ProductBO.create(dto.getName(), dto.getStock(), dto.getPrice());
    }

    public static ProductResponseDTO toResponseDto(ProductBO bo) {
        ProductResponseDTO response = new ProductResponseDTO();
        response.setId(bo.getId());
        response.setName(bo.getName());
        response.setStock(bo.getStock());
        response.setPrice(bo.getPrice());
        response.setFinalPrice(bo.getFinalPrice());
        return response;
    }
}
