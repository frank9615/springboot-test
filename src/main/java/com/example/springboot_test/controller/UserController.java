package com.example.springboot_test.controller;

import com.example.springboot_test.dto.UserDto;
import com.example.springboot_test.model.Card;
import com.example.springboot_test.model.User;
import com.example.springboot_test.service.interfaces.IUserService;
import com.example.springboot_test.servicedto.interfaces.IUserDtoService;
import lombok.SneakyThrows;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.util.Objects.isNull;

@RestController
@RequestMapping("api/v1/users")
@Log
public class UserController {

    @Autowired
    IUserDtoService userDtoService;

    @Autowired
    IUserService userService;

    @SneakyThrows
    @GetMapping(value = "/findby/name/{name}" , produces = "application/json")
    public ResponseEntity<UserDto> findByName(@PathVariable("name") String name){
        log.info("Received request to find user by name: " + name);
        UserDto userdto = this.userDtoService.findByName(name);
        if(isNull(userdto)){
            return new ResponseEntity<UserDto>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<UserDto>(userdto, HttpStatus.OK);
    }

    @SneakyThrows
    @GetMapping(value = "/findby2/name/{name}" , produces = "application/json")
    public ResponseEntity<User> findByName2(@PathVariable("name") String name){
        log.info("Received request 2 to find user by name: " + name);
        User user = this.userService.findByName(name);
        if(isNull(user)){
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @SneakyThrows
    @GetMapping(value = "/init" , produces = "application/json")
    public ResponseEntity<String> init(){
        log.info("Init db with data, call only one time - test only");
        User user = new User();
        user.setName("francesco");

        Card card1 = Card.builder().cardName("card1").build();
        Card card2 = Card.builder().cardName("card2").build();
        Card card3 = Card.builder().cardName("card3").build();
        Card card4 = Card.builder().cardName("card4").build();

        // User1 has card1 and card2 and card3 and card4
        user.getCards().add(card1);
        user.getCards().add(card2);
        user.getCards().add(card3);
        user.getCards().add(card4);

        this.userService.savaUser(user);
        return new ResponseEntity<String>("ok", HttpStatus.OK);
    }
}
