package com.example.skincare.service.impl;

import com.example.skincare.model.views.ProductsPerCategory;
import com.example.skincare.repository.views.ProductsPerCategoryRepository;
import com.example.skincare.service.ProductsPerCategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsPerCategoryServiceImpl implements ProductsPerCategoryService {

    private final ProductsPerCategoryRepository productsPerCategoryRepository;

    public ProductsPerCategoryServiceImpl(ProductsPerCategoryRepository productsPerCategoryRepository) {
        this.productsPerCategoryRepository = productsPerCategoryRepository;
    }

    @Override
    public List<ProductsPerCategory> listAll() {
        return this.productsPerCategoryRepository.findAll();
    }

    @Override
    public Optional<ProductsPerCategory> findById(Long id) {
        return this.productsPerCategoryRepository.findById(id);
    }

    @Override
    public List<ProductsPerCategory> findAllByCategory_id(Long id) {
        return this.productsPerCategoryRepository.findAllByCategory(id);
    }
}
