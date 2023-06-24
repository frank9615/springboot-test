package com.example.springboot_test.servicedto.interfaces;

import com.example.springboot_test.dto.UserDto;
import com.example.springboot_test.model.User;

public interface IUserDtoService {
    UserDto findByName(String name);
}
