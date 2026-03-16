package com.fag.felipeheringer.arquitetura_software.model.bo;

import java.math.BigDecimal;

public class ProductBO {
    
    private Long id;
    private String name;
    private Integer stock;
    private BigDecimal price;
    private BigDecimal finalPrice;

    private static final BigDecimal PREMIUM_MIN_PRICE = new BigDecimal("100.00");
    private static final BigDecimal STOCK_DISCOUNT_RATE = new BigDecimal("0.10");
    private static final int STOCK_DISCOUNT_THRESHOLD = 50;

    private ProductBO(Long id, String name, Integer stock, BigDecimal price, BigDecimal finalPrice) {
        this.id = id;
        this.name = name;
        this.stock = stock;
        this.price = price;
        this.finalPrice = finalPrice;
    }

    private ProductBO(String name, Integer stock, BigDecimal price) {
        this(null, name, stock, price, price);
    }

    public static ProductBO create(String name, Integer stock, BigDecimal price) {
        ProductBO productBO = new ProductBO(name, stock, price);

        if (isPremiumProduct(productBO)) {
            verifyPrice(price);
        }

        if (qualifiesForStockDiscount(productBO)) {
            applyStockDiscount(productBO);
        }

        return productBO;
    }

    public static ProductBO createWithId(Long id, String name, Integer stock, BigDecimal price, BigDecimal finalPrice) {
        ProductBO productBO = new ProductBO(id, name, stock, price, finalPrice);
        return productBO;
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

    // Bussines Logic
    private static boolean isPremiumProduct(ProductBO productBO) {
        return productBO.getName().toLowerCase().contains("premium");
    }

    private static void verifyPrice(BigDecimal price) {
        if (price.compareTo(PREMIUM_MIN_PRICE) < 0) {
            throw new IllegalArgumentException("Erro: Produtos Premium não podem custar menos de R$ 100,00.");
        }
    }

    
    private static boolean qualifiesForStockDiscount(ProductBO productBO) {
        return productBO.getStock() >= STOCK_DISCOUNT_THRESHOLD;
    }

    private static void applyStockDiscount(ProductBO productBO) {
        // Aplica desconto de 10%
        BigDecimal discountAmount = productBO.getPrice().multiply(STOCK_DISCOUNT_RATE);
        BigDecimal discountedPrice = productBO.getPrice().subtract(discountAmount);
        productBO.setFinalPrice(discountedPrice);
    }

    public static BigDecimal getPremiumMinPrice() {
        return PREMIUM_MIN_PRICE;
    }

    public static BigDecimal getStockDiscountRate() {
        return STOCK_DISCOUNT_RATE;
    }

    public static int getStockDiscountThreshold() {
        return STOCK_DISCOUNT_THRESHOLD;
    }
}
