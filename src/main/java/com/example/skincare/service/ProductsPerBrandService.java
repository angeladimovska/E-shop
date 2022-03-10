package com.example.skincare.service;

import com.example.skincare.model.views.ProductsPerBrand;
import com.example.skincare.model.views.ProductsPerCategory;

import java.util.List;

public interface ProductsPerBrandService {
    List<ProductsPerBrand> findAllByBrandId(long id);

}
