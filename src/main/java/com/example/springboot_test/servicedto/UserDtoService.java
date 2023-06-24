package com.example.springboot_test.servicedto;

import com.example.springboot_test.dto.UserDto;
import com.example.springboot_test.model.User;
import com.example.springboot_test.service.interfaces.IUserService;
import com.example.springboot_test.servicedto.interfaces.IUserDtoService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

@Service
@Log
public class UserDtoService implements IUserDtoService {

    @Autowired
    private IUserService userService;
    @Override
    public UserDto findByName(String name) {
        User user =  userService.findByName(name);
        if(isNull(user)){
            return null;
        }
        //Manual mapping -> use modelmapper instead
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .build();
    }
}
