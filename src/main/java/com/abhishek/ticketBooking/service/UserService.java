package com.abhishek.ticketBooking.service;


import com.abhishek.ticketBooking.entity.User;
import com.abhishek.ticketBooking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public Object login(String email, String password) {
        User user = repository.findByEmail(email).orElse(null);
        if (user == null) {
            return "User not found";
        }
        String userPass = user.getPassword();
        if (Objects.equals(userPass, password)) {
            return user;
        }
        return "User not found";
    }

    public User signup(String name, String password, String email) {
        User user = new User();
        user.setEmail(email);
        user.setName(name);
        user.setPassword(password);
        return repository.save(user);
    }

}
