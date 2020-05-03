package com.example.demo.dto;

import com.example.demo.Entity.UserEntity;
import com.example.demo.request.UserRegisterRequest;

public class UserDto {

    private int id;
    private String username;
    private String password;
    private String token = "";

    public UserDto() {

    }

    public UserDto(UserEntity user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.token = user.getToken();
    }

    public void setDataRequest(UserRegisterRequest dataRequest) {
        this.username = dataRequest.getUsername();
        this.password = dataRequest.getPassword();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    

}