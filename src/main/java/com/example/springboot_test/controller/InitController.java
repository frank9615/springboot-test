package com.example.springboot_test.controller;

import com.example.springboot_test.model.Card;
import com.example.springboot_test.model.User;
import com.example.springboot_test.service.interfaces.IUserService;
import lombok.SneakyThrows;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/inits")
@Log
public class InitController {

    @Autowired
    IUserService userService;

    @SneakyThrows
    @GetMapping(value = "/init" , produces = "application/json")
    public ResponseEntity<String> init(){
        log.info("Init db with data, call only one time - test only");
        User user = new User();
        user.setName("francesco");

        User user2 = new User();

        Card card1 = Card.builder()
                .cardName("card1")
                .build();
        Card card2 = Card.builder()
                .cardName("card2")
                .build();
        Card card3 = Card.builder()
                .cardName("card3")
                .build();
        Card card4 = Card.builder()
                .cardName("card4")
                .build();

        // User1 has card1 and card2 and card3 and card4
        user.getCards().add(card1);
        user.getCards().add(card2);
        user.getCards().add(card3);
        user.getCards().add(card4);

        user2.getCards().add(card3);
        user2.getCards().add(card4);

        this.userService.savaUser(user);
        return new ResponseEntity<String>("ok", HttpStatus.OK);
    }
}
