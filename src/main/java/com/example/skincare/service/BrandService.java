package com.example.skincare.service;

import com.example.skincare.model.Brand;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface BrandService {

    Optional<Brand> findById(Long id);

    List<Brand> findAll();

    Optional<Brand> save(String name, MultipartFile image);

    void deleteById(Long id);
}
