package com.example.skincare.service;

import com.example.skincare.model.Brand;
import com.example.skincare.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface CategoryService {

    Optional<Category> findById(Long id);

    List<Category> findAll();

    Optional<Category> save(String name);

    void deleteById(Long id);
}
