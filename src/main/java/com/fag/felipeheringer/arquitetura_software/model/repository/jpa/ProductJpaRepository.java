package com.fag.felipeheringer.arquitetura_software.model.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fag.felipeheringer.arquitetura_software.model.repository.entity.ProductEntity;

@Repository
public interface ProductJpaRepository extends JpaRepository<ProductEntity, Integer> {
    
}
