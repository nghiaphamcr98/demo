package com.example.demo.controller;

import com.example.demo.Entity.UserEntity;
import com.example.demo.dao.UserDao;
import com.example.demo.dto.UserDto;
import com.example.demo.security.JWTUtil;
import com.example.demo.util.AppUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;

@Service
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserDao userDao;

    public UserDto save(UserDto user) {
        try {
            UserEntity result = new UserEntity(user);
            result = userDao.save(result);
            if(result != null) {
                return new UserDto(result);
            }
        } catch (Exception e) {
            logger.error(AppUtil.getStackTrace(e));
        }
        return null;
    }

    public UserDto getDetail(int id) {
        try {
            Boolean bool = userDao.existsById(id);
            if(bool == true) {
                UserEntity result = userDao.getOne(id);
                return new UserDto(result);
            }
        } catch (Exception e) {
            logger.error(AppUtil.getStackTrace(e));
        }
        return null;
    }

    public UserDto getDetail(String username) {
        try {
            UserEntity result = userDao.getDetailUser(username);
            if(result != null) {
                return new UserDto(result);
            }
        } catch (Exception e) {
            logger.error(AppUtil.getStackTrace(e));
        }
        return null;
    }

    public boolean validateUser(String bearerToken) {
        try {
            if (bearerToken == null || bearerToken.isEmpty()) {
                return false;
            }
            if (!bearerToken.startsWith("Bearer")) {
                return false;
            }
            String token = bearerToken.substring(7, bearerToken.length());
            if (!JWTUtil.validateToken(token)) {
                return false;
            }
            Claims claims = JWTUtil.decodeJWT(token);
            String username = claims.getSubject();
            UserEntity user = userDao.getDetailUser(username);
            if (user.getToken().isEmpty()) {
                return false;
            }
            if (!user.getToken().equals(token)) {
                user.setToken("");
                return false;

            }
        } catch (Exception ex) {
            return false;
        }

        return true;
    }

    public UserDto getDetailByToken(String bearerToken) {
        try {
            if (bearerToken == null || bearerToken.isEmpty()) {
                return null;
            }
            if (!bearerToken.startsWith("Bearer")) {
                return null;
            }
            String token = bearerToken.substring(7, bearerToken.length());
            if (!JWTUtil.validateToken(token)) {
                return null;
            }
            Claims claims = JWTUtil.decodeJWT(token);
            String username = claims.getSubject();

            UserEntity result = userDao.getDetailUser(username);
            if(result != null) {
                return new UserDto(result);
            }
        } catch (Exception e) {
            logger.error(AppUtil.getStackTrace(e));
        }
        return null;
    }

}