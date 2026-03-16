package com.fag.felipeheringer.arquitetura_software.model.repository.mapper;

import com.fag.felipeheringer.arquitetura_software.model.bo.ProductBO;
import com.fag.felipeheringer.arquitetura_software.model.repository.entity.ProductEntity;

public class ProductEntityMapper {
    

    private ProductEntityMapper() {
    }

    public static ProductEntity toEntity(ProductBO bo) {
        ProductEntity entity = ProductEntity.create(bo);
        return entity;
    }

    public static ProductBO toBo(ProductEntity entity) {
        ProductBO productBO = ProductBO.createWithId(
            entity.getId(), entity.getName(), entity.getStock(), entity.getPrice(), entity.getFinalPrice()
        );

        return productBO;
    }
}
