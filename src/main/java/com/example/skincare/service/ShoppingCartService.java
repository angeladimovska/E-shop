package com.example.skincare.service;

import com.example.skincare.model.Product;
import com.example.skincare.model.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {

    List<Product> listAllProductsInShoppingCart(Long cartId);

    //da ja zemam kosnickata sho vo momentot e aktivna
    ShoppingCart getActiveShoppingCart(String username);

    //dodadi produkt vo kosnicka
    //vo koja kosnicka-username, koj proizvod-id na proizvodot
    ShoppingCart addProductToShoppingCart(String username, Long productId);

    void deleteProductFromShoppingCart(String username, Long productId);
}
