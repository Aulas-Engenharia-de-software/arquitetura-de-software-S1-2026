package com.fag.felipeheringer.arquitetura_software.model.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fag.felipeheringer.arquitetura_software.model.bo.ProductBO;
import com.fag.felipeheringer.arquitetura_software.model.repository.ProductRepository;
import com.fag.felipeheringer.arquitetura_software.model.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;
    

    @Override
    public ProductBO create(ProductBO productBO) {
        
        return productRepository.save(productBO);
    }
    
    
}
