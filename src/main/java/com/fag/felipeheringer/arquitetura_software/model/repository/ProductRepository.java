package com.fag.felipeheringer.arquitetura_software.model.repository;

import com.fag.felipeheringer.arquitetura_software.model.bo.ProductBO;

public interface ProductRepository {
    
    ProductBO save(ProductBO productBO);
}
