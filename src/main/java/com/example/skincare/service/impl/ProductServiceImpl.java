package com.example.skincare.service.impl;

import com.example.skincare.model.Brand;
import com.example.skincare.model.Category;
import com.example.skincare.model.Discount;
import com.example.skincare.model.Product;
import com.example.skincare.model.dto.ProductDto;
import com.example.skincare.model.exceptions.BrandNotFoundException;
import com.example.skincare.model.exceptions.CategoryNotFoundException;
import com.example.skincare.model.exceptions.DiscountNotFoundException;
import com.example.skincare.model.exceptions.ProductNotFoundException;
import com.example.skincare.repository.BrandRepository;
import com.example.skincare.repository.CategoryRepository;
import com.example.skincare.repository.DiscountRepository;
import com.example.skincare.repository.ProductRepository;
import com.example.skincare.service.ProductService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final BrandRepository brandRepository;
    private final CategoryRepository categoryRepository;
    private final DiscountRepository discountRepository;

    public ProductServiceImpl(ProductRepository productRepository, BrandRepository brandRepository, CategoryRepository categoryRepository, DiscountRepository discountRepository) {
        this.productRepository = productRepository;
        this.brandRepository = brandRepository;
        this.categoryRepository = categoryRepository;
        this.discountRepository = discountRepository;
    }

    @Override
    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return this.productRepository.findById(id);
    }

    @Override
    public Optional<Product> findByName(String name) {
        return this.productRepository.findByName(name);
    }

    @Override
    public Optional<Product> save(String name, Double price, Integer quantity,
                                  Long categoryId, Long brandId) {

          Category category = this.categoryRepository.findById(categoryId)
                    .orElseThrow(() -> new CategoryNotFoundException(categoryId));

            Brand brand = this.brandRepository.findById(brandId)
                    .orElseThrow(() -> new BrandNotFoundException(brandId));

            Product product = new Product(name, price, quantity, category, brand);

            return Optional.of(this.productRepository.save(product));
        }

    @Override
    public Optional<Product> save(ProductDto productDto) {
        Category category = this.categoryRepository.findById(productDto.getCategory())
                .orElseThrow(() -> new CategoryNotFoundException(productDto.getCategory()));

        Brand brand = this.brandRepository.findById(productDto.getBrand())
                .orElseThrow(() -> new BrandNotFoundException(productDto.getBrand()));

        this.productRepository.deleteByName(productDto.getName());
        return Optional.of(this.productRepository.save(new Product(productDto.getName(), productDto.getPrice(), productDto.getQuantity(), category, brand)));

    }

    @Override
    public Optional<Product> edit(Long id, String name, Double price, Integer quantity,
                                  Long categoryId, Long brandId) {

        Product product = this.productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));

        product.setName(name);
        product.setPrice(price);
        product.setQuantity(quantity);

        Category category = this.categoryRepository.findById(categoryId)
                .orElseThrow(() -> new CategoryNotFoundException(categoryId));
        product.setCategory(category);

        Brand brand = this.brandRepository.findById(brandId)
                .orElseThrow(() -> new BrandNotFoundException(brandId));
        product.setBrand(brand);

        return Optional.of(this.productRepository.save(product));
    }

    @Override
    public Optional<Product> edit(Long id, ProductDto productDto) {
        Product product = this.productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));

        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setQuantity(productDto.getQuantity());

        Category category = this.categoryRepository.findById(productDto.getCategory())
                .orElseThrow(() -> new CategoryNotFoundException(productDto.getCategory()));
        product.setCategory(category);

        Brand brand = this.brandRepository.findById(productDto.getBrand())
                .orElseThrow(() -> new BrandNotFoundException(productDto.getBrand()));
        product.setBrand(brand);

        return Optional.of(this.productRepository.save(product));

    }

    @Override
    public void deleteById(Long id) {
        this.productRepository.deleteById(id);
    }
}
