package com.example.skincare.web;

import com.example.skincare.model.Brand;
import com.example.skincare.model.Category;
import com.example.skincare.model.Product;
import com.example.skincare.model.views.ProductsPerBrand;
import com.example.skincare.model.views.ProductsPerCategory;
import com.example.skincare.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductsController {

    private final ProductService productService;
    private final CategoryService categoryService;
    private final BrandService brandService;
    private final ProductsPerCategoryService productsPerCategoryService;
    private final ProductsPerBrandService productsPerBrandService;

    public ProductsController(ProductService productService, CategoryService categoryService, BrandService brandService, ProductsPerCategoryService productsPerCategoryService, ProductsPerBrandService productsPerBrandService) {
        this.productService = productService;
        this.categoryService = categoryService;
        this.brandService = brandService;
        this.productsPerCategoryService = productsPerCategoryService;
        this.productsPerBrandService = productsPerBrandService;
    }

    @GetMapping
    public String getProductPage(@RequestParam(required = false) String error, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }

        List<Product> products = this.productService.findAll();
        model.addAttribute("products", products);

        List<Brand> brands=this.brandService.findAll();
        List<Category> categories = this.categoryService.findAll();
        model.addAttribute("brands", brands);
        model.addAttribute("categories", categories);
        return "products";
    }
    @GetMapping("/add-form")
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    public String addProductPage(Model model) {
        List<Brand> brands=this.brandService.findAll();

        List<Category> categories = this.categoryService.findAll();

        model.addAttribute("brands", brands);
        model.addAttribute("categories", categories);

        return "add-product";
    }

    @GetMapping("/edit-form/{id}")
    public String editProductPage(@PathVariable Long id, Model model) {
        if (this.productService.findById(id).isPresent()) {
            Product product = this.productService.findById(id).get();
            List<Brand> brands=this.brandService.findAll();
            List<Category> categories = this.categoryService.findAll();
            model.addAttribute("brands", brands);
            model.addAttribute("categories", categories);
            model.addAttribute("product", product);
            return "add-product";
        }
        return "redirect:/products?error=ProductNotFound";
    }

    @PostMapping("/add")
    public String saveProduct(@RequestParam(required = false) Long id,
            @RequestParam String name,
            @RequestParam Double price,
            @RequestParam Integer quantity,
            @RequestParam Long category,
            @RequestParam Long brand) {
        if (id != null) {
            this.productService.edit(id, name, price, quantity, category, brand);
        } else {
            this.productService.save(name, price, quantity, category, brand);
        }
        return "redirect:/products";
    }

    @PostMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        this.productService.deleteById(id);
        return "redirect:/products";
    }

    @GetMapping("/probno/{id}")
    public String getProductsPerCategory(@PathVariable Long id,
                                         @RequestParam(required = false) String error, Model model){
        if(error!=null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }

        List<ProductsPerCategory> productsPerCategory=this.productsPerCategoryService.findAllByCategory_id(id);
        model.addAttribute("productsPerCategory",productsPerCategory);

        List<ProductsPerBrand> productsPerBrand =this.productsPerBrandService.findAllByBrandId(id);
        model.addAttribute("productsPerBrand",productsPerBrand);

        List<Brand> brands=this.brandService.findAll();
        List<Category> categories = this.categoryService.findAll();
        model.addAttribute("brands", brands);
        model.addAttribute("categories", categories);
        return "productsPerCategory";
    }
}
