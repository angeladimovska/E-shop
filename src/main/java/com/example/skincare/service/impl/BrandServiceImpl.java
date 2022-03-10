package com.example.skincare.service.impl;

import org.springframework.util.StringUtils;
import com.example.skincare.model.Brand;
import com.example.skincare.repository.BrandRepository;
import com.example.skincare.service.BrandService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public Optional<Brand> findById(Long id) {
        return this.brandRepository.findById(id);
    }

    @Override
    public List<Brand> findAll() {
        return this.brandRepository.findAll();
    }

    @Override
    public Optional<Brand> save(String name, MultipartFile file) {

        String fileName= StringUtils.cleanPath(file.getOriginalFilename());
        if(fileName.isEmpty() || fileName.contains(".."))
        {
            System.out.println("not a valid file");
        }
        String image= null;
        try {
            image = Base64.getEncoder().encodeToString(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        Brand brand= new Brand(name, image);
        return Optional.of(this.brandRepository.save(brand));
    }

    @Override
    public void deleteById(Long id) {
       this.brandRepository.deleteById(id);
    }
}
