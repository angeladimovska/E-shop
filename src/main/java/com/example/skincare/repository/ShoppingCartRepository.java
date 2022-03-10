package com.example.skincare.repository;

import com.example.skincare.model.ShoppingCart;
import com.example.skincare.model.User;
import com.example.skincare.model.enumerations.ShoppingCartStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
    //sega ke treba da stavis tuka USER A NE USERNAME
    Optional<ShoppingCart> findByUserAndStatus(User user, ShoppingCartStatus status);

}
