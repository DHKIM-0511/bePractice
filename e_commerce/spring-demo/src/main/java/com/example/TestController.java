package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping(value = "/test")
    public UserDto test(){

        UserDto user = new UserDto();
        user.setAge(20);
        user.setName("Kim");
        return user;
    }
}
