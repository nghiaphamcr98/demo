package com.example.demo.dao;

import com.example.demo.Entity.UserEntity;
import com.example.demo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDao {

    @Autowired
    UserRepository userRepository;
    
    public UserEntity save(UserEntity user) {
        return userRepository.save(user);
    }

    public Boolean existsById (int id) {
        return userRepository.existsById(id);
    }

    public UserEntity getOne(int id) {
        return userRepository.getOne(id);
    }
    
    public UserEntity getDetailUser(String username) {
        return userRepository.getDetailUser(username);
    }

}