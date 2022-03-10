package com.example.skincare.service;

import com.example.skincare.model.views.ProductsPerCategory;

import java.util.List;
import java.util.Optional;

public interface ProductsPerCategoryService {
    List<ProductsPerCategory> listAll();

    Optional<ProductsPerCategory> findById(Long id);
    List<ProductsPerCategory> findAllByCategory_id(Long id);
}
