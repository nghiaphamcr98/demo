package com.example.demo.service;

import com.example.demo.request.UserRegisterRequest;

import org.json.simple.JSONObject;

public interface UserService {

    JSONObject login(String username, String password);

    JSONObject register(UserRegisterRequest data);
}