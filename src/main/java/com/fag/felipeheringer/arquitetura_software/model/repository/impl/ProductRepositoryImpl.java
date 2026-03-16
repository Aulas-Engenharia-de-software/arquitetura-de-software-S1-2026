package com.fag.felipeheringer.arquitetura_software.model.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fag.felipeheringer.arquitetura_software.model.bo.ProductBO;
import com.fag.felipeheringer.arquitetura_software.model.repository.ProductRepository;
import com.fag.felipeheringer.arquitetura_software.model.repository.entity.ProductEntity;
import com.fag.felipeheringer.arquitetura_software.model.repository.jpa.ProductJpaRepository;
import com.fag.felipeheringer.arquitetura_software.model.repository.mapper.ProductEntityMapper;

@Component
public class ProductRepositoryImpl implements ProductRepository {

    @Autowired
    private ProductJpaRepository jpaRepository;

    @Override
    public ProductBO save(ProductBO productBO) {
        ProductEntity entity = ProductEntityMapper.toEntity(productBO);

        ProductEntity entitySaved = jpaRepository.save(entity);

        return ProductEntityMapper.toBo(entitySaved);
    }
    
    
}
