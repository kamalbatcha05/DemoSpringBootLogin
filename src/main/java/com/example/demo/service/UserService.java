package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.User;

public interface UserService {
    User findUserByEmail(String email);
    void saveUser(User user);
    List<User> getAllUsers();
}
