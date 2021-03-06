package com.example.skincare.service.impl;

import com.example.skincare.model.User;
import com.example.skincare.model.enumerations.Role;
import com.example.skincare.model.exceptions.InvalidArgumentsException;
import com.example.skincare.model.exceptions.InvalidUserCredentialsException;
import com.example.skincare.model.exceptions.PasswordsDoNotMatchException;
import com.example.skincare.model.exceptions.UsernameAlreadyExistsException;
import com.example.skincare.repository.UserRepository;
import com.example.skincare.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User login(String username, String password) {
        if (username==null || username.isEmpty() || password==null || password.isEmpty()) {
            throw new InvalidArgumentsException();
        }
        return userRepository.findByUsernameAndPassword(username,
                password).orElseThrow(InvalidUserCredentialsException::new);
    }

    @Override
    public User register(String username, String password, String repeatPassword, String name, String surname) {
        if (username==null || username.isEmpty()  || password==null || password.isEmpty())
            throw new InvalidArgumentsException();
        if (!password.equals(repeatPassword))
            throw new PasswordsDoNotMatchException();

        if(this.userRepository.findByUsername(username).isPresent())
            throw new UsernameAlreadyExistsException(username);

        User user = new User(username,password,name,surname);
        return userRepository.save(user);
    }
}
