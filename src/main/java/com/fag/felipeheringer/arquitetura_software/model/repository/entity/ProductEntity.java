package com.fag.felipeheringer.arquitetura_software.model.repository.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fag.felipeheringer.arquitetura_software.model.bo.ProductBO;

@Entity
@Table(name = "tbl_produtos")
public class ProductEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String name;

    @Column(name = "estoque")
    private Integer stock;

    @Column(name = "preco")
    private BigDecimal price;

    @Column(name = "preco_final")
    private BigDecimal finalPrice;

    private ProductEntity() {
    }

    public static ProductEntity create(ProductBO productBO) {
        ProductEntity entity = new ProductEntity();
        entity.setName(productBO.getName());
        entity.setStock(productBO.getStock());
        entity.setPrice(productBO.getPrice());
        entity.setFinalPrice(productBO.getFinalPrice());
        return entity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(BigDecimal finalPrice) {
        this.finalPrice = finalPrice;
    }
}
