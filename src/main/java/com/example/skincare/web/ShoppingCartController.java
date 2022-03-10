package com.example.skincare.web;

import com.example.skincare.model.ShoppingCart;
import com.example.skincare.model.User;
import com.example.skincare.service.BrandService;
import com.example.skincare.service.CategoryService;
import com.example.skincare.service.ShoppingCartService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/shopping-cart")
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;
    private final BrandService brandService;
    private final CategoryService categoryService;

    public ShoppingCartController(ShoppingCartService shoppingCartService, BrandService brandService, CategoryService categoryService) {
        this.shoppingCartService = shoppingCartService;
        this.brandService = brandService;
        this.categoryService = categoryService;
    }

    @GetMapping
    public String getShoppingCartPage(@RequestParam(required = false) String error,
                                      HttpServletRequest req,
                                      Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }

        User user= (User) req.getSession().getAttribute("user");
        ShoppingCart shoppingCart = this.shoppingCartService.getActiveShoppingCart(user.getUsername());
        model.addAttribute("products", this.shoppingCartService.listAllProductsInShoppingCart(shoppingCart.getId()));
        model.addAttribute("brands", this.brandService.findAll());
        model.addAttribute("categories", this.categoryService.findAll());
        return "shopping-cart";
    }

    @PostMapping("/add-product/{id}")
    public String addProductToShoppingCart(@PathVariable Long id, HttpServletRequest req, Authentication authentication){
        try {

            User user = (User) req.getSession().getAttribute("user");
            this.shoppingCartService.addProductToShoppingCart(user.getUsername(), id);
            return "redirect:/shopping-cart";
        } catch (RuntimeException exception) {
            return "redirect:/shopping-cart?error=" + exception.getMessage();
        }
    }

    @PostMapping("/delete-product/{id}")
    public String deleteProductFromShoppingCart(@PathVariable Long id,
                                                HttpServletRequest req){
        try {
            User user = (User) req.getSession().getAttribute("user");
            this.shoppingCartService.deleteProductFromShoppingCart(user.getUsername(), id);
            return "redirect:/shopping-cart";
        } catch (RuntimeException exception) {
            return "redirect:/shopping-cart?error=" + exception.getMessage();
        }
    }

}
