package com.example.springboot_test.service;

import com.example.springboot_test.model.User;
import com.example.springboot_test.repository.UserRepository;
import com.example.springboot_test.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByName(String name) {
        return this.userRepository.findByName(name);
    }

    @Override
    public void savaUser(User user) {
        this.userRepository.save(user);
    }
}
