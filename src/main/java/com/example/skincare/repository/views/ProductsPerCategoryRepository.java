package com.example.skincare.repository.views;

import com.example.skincare.model.views.ProductsPerCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsPerCategoryRepository extends JpaRepository<ProductsPerCategory, Long> {

    List<ProductsPerCategory> findAllByCategory(Long id);
}
