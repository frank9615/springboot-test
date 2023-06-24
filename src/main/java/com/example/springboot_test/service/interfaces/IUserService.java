package com.example.springboot_test.service.interfaces;

import com.example.springboot_test.model.User;

public interface IUserService {
    User findByName(String name);
    void savaUser(User user);
}
