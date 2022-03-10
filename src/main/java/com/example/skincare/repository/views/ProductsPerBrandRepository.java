package com.example.skincare.repository.views;

import com.example.skincare.model.views.ProductsPerBrand;
import com.example.skincare.model.views.ProductsPerCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsPerBrandRepository extends JpaRepository<ProductsPerBrand, Long> {

    List<ProductsPerBrand> findAllByBrand(Long id);
}
