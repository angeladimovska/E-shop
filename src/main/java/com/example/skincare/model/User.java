package com.example.skincare.model;


import com.example.skincare.model.enumerations.Role;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "shop_users")//user e rezerviran zbor i kje dobiesh error ako ne go smenis imeto na tabelata
public class User {

    @Id
    private String username;

    private String password;

    private String name;

    private String surname;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    @OneToOne
    private LoyaltyCard card;

    public User() {
    }

    public User(String username, String password, String name, String surname) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }
}
