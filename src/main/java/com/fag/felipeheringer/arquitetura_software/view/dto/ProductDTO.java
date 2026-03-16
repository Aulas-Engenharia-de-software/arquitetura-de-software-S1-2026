package com.fag.felipeheringer.arquitetura_software.view.dto;

import java.math.BigDecimal;

public class ProductDTO {
    
    private String name;
    private Integer stock;
    private BigDecimal price;

    public ProductDTO(String name, Integer stock, BigDecimal price) {
        this.name = name;
        this.stock = stock;
        this.price = price;
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

    
}
