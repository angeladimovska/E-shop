package com.example.skincare.service;

import com.example.skincare.model.Product;
import com.example.skincare.model.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {

    List<Product> listAllProductsInShoppingCart(Long cartId);

    ShoppingCart getActiveShoppingCart(String username);

    ShoppingCart addProductToShoppingCart(String username, Long productId);

    void deleteProductFromShoppingCart(String username, Long productId);
}
