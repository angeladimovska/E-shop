package com.example.skincare.service.impl;

import com.example.skincare.model.views.ProductsPerBrand;
import com.example.skincare.repository.views.ProductsPerBrandRepository;
import com.example.skincare.service.ProductsPerBrandService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsPerBrandImpl implements ProductsPerBrandService {

    private final ProductsPerBrandRepository productsPerBrandRepository;

    public ProductsPerBrandImpl(ProductsPerBrandRepository productsPerBrandRepository) {
        this.productsPerBrandRepository = productsPerBrandRepository;
    }

    @Override
    public List<ProductsPerBrand> findAllByBrandId(long id) {
        return this.productsPerBrandRepository.findAllByBrand(id);
    }
}
