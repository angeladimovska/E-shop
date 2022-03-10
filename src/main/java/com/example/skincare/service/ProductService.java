package com.example.skincare.service;

import com.example.skincare.model.Product;
import com.example.skincare.model.dto.ProductDto;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> findAll();

    Optional<Product> findById(Long id);

    Optional<Product> findByName(String name);

    Optional<Product> save(String name, Double price, Integer quantity, Long category, Long brand);

    Optional<Product> save(ProductDto productDto);

    Optional<Product> edit(Long id, String name, Double price, Integer quantity, Long category, Long brand);

    Optional<Product> edit(Long id, ProductDto productDto);

    void deleteById(Long id);
}
