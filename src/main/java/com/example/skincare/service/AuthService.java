package com.example.skincare.service;

import com.example.skincare.model.User;
import com.example.skincare.model.enumerations.Role;

public interface AuthService {

    User login(String username, String password);
    User register(String username, String password, String repeatPassword, String name, String surname);
}
