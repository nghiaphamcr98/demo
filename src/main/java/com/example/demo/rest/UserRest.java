package com.example.demo.rest;

import com.example.demo.request.UserRegisterRequest;
import com.example.demo.service.UserService;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("/user")
public class UserRest {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public JSONObject login(
            @RequestParam String username,
            @RequestParam String password
            ) {
        return userService.login(username, password);
    }

    @PostMapping("/register")
    public JSONObject register(
            @RequestBody UserRegisterRequest data
            ) {
        return userService.register(data);
    }

}