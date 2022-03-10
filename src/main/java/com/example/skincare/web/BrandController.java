package com.example.skincare.web;

import com.example.skincare.model.Brand;
import com.example.skincare.service.BrandService;
import com.example.skincare.service.ProductsPerCategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/brands")
public class BrandController {

    private final BrandService brandService;
    private final ProductsPerCategoryService productsPerCategoryService;

    public BrandController(BrandService brandService, ProductsPerCategoryService productsPerCategoryService) {
        this.brandService = brandService;
        this.productsPerCategoryService = productsPerCategoryService;
    }

    @GetMapping
    public String getBrandPage(@RequestParam(required = false) String error, Model model){
        if(error!=null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        List<Brand> brandList= this.brandService.findAll();
        model.addAttribute("brandList", brandList);
        return "brands";
    }

    @GetMapping("/add-form")
    public String addBrandPage() {
        return "add-brand";
    }

    @PostMapping("/add")
    public String saveBrand(@RequestParam String name,
                            @RequestParam MultipartFile file) {
        this.brandService.save(name, file);
        return "redirect:/brands";
    }

    @PostMapping("/delete/{id}")
    public String deleteBrand(@PathVariable Long id){
        this.brandService.deleteById(id);
        return "redirect:/brands";
    }



}
