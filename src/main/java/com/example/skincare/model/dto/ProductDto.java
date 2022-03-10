package com.example.skincare.model.dto;

import lombok.Data;

@Data
public class ProductDto {

    private String name;

    private Double price;

    private Integer quantity;

    private Long category;

    private Long brand;

    public ProductDto() {
    }

    public ProductDto(String name, Double price, Integer quantity, Long category, Long brand) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
        this.brand=brand;
    }
}
