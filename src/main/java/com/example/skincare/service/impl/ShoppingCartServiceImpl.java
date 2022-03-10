package com.example.skincare.service.impl;

import com.example.skincare.model.Product;
import com.example.skincare.model.ShoppingCart;
import com.example.skincare.model.User;
import com.example.skincare.model.enumerations.ShoppingCartStatus;
import com.example.skincare.model.exceptions.ProductAlreadyInShoppingCartException;
import com.example.skincare.model.exceptions.ProductNotFoundException;
import com.example.skincare.model.exceptions.ShoppingCartNotFoundException;
import com.example.skincare.model.exceptions.UserNotFoundException;
import com.example.skincare.repository.ShoppingCartRepository;
import com.example.skincare.repository.UserRepository;
import com.example.skincare.service.ProductService;
import com.example.skincare.service.ShoppingCartService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;
    private final UserRepository userRepository;
    private final ProductService productService;

    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository, UserRepository userRepository, ProductService productService) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.userRepository = userRepository;
        this.productService = productService;
    }

    @Override
    public List<Product> listAllProductsInShoppingCart(Long cartId) {
            if(!this.shoppingCartRepository.findById(cartId).isPresent())
                throw new ShoppingCartNotFoundException(cartId);

            //gi vrakjam site produkti vo kosnickata
            return this.shoppingCartRepository.findById(cartId).get().getProducts();
    }

    @Override
    public ShoppingCart getActiveShoppingCart(String username) {

        User user=this.userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException(username));

        return this.shoppingCartRepository.findByUserAndStatus(user,
                ShoppingCartStatus.CREATED)
                //sega else e ako nemam aktivna kosnicka da kreiram nova
                .orElseGet(() ->{
                    ShoppingCart cart = new ShoppingCart(user);
                    return this.shoppingCartRepository.save(cart);
                });
    }

    @Override
    public ShoppingCart addProductToShoppingCart(String username, Long productId) {

       //prvo vidi dali ima aktivna kosnicka za korisnikot sho go davas preku username
        ShoppingCart shoppingCart=this.getActiveShoppingCart(username);

        //koj mi e produktot shto sakam da go doadam
        Product product=this.productService.findById(productId)
                .orElseThrow(()->new ProductNotFoundException(productId));

        //dali produktot shto sakam da go dodadam veke postoi vo taa kosnicka
        if(shoppingCart.getProducts()
                .stream().filter(p ->p.getId().equals(productId))
                .collect(Collectors.toList()).size() > 0)
            throw new ProductAlreadyInShoppingCartException(productId, username);

        shoppingCart.getProducts().add(product);
        return this.shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public void deleteProductFromShoppingCart(String username, Long productId) {
        //zemi ja aktivnata kosnicka za korisnikot
        ShoppingCart shoppingCart=this.getActiveShoppingCart(username);
    }
}
