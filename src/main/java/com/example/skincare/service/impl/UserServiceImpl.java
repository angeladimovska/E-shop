package com.example.skincare.service.impl;

import com.example.skincare.model.User;
import com.example.skincare.model.enumerations.Role;
import com.example.skincare.model.exceptions.PasswordsDoNotMatchException;
import com.example.skincare.model.exceptions.UsernameAlreadyExistsException;
import com.example.skincare.repository.UserRepository;
import com.example.skincare.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User register(String username, String password, String repeatPassword, String name, String surname, Role role) {
//        if (username==null || username.isEmpty()  || password==null || password.isEmpty())
//            throw new InvalidUsernameOrPasswordException();
//        if (!password.equals(repeatPassword))
//            throw new PasswordsDoNotMatchException();
//        if(this.userRepository.findByUsername(username).isPresent())
//            throw new UsernameAlreadyExistsException(username);
//
//        User user = new User(username, password, name, surname, userRole);
//        return userRepository.save(user);
        return null;
    }
}
