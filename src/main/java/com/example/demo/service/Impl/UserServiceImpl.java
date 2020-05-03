package com.example.demo.service.Impl;

import com.example.demo.controller.UserController;
import com.example.demo.dao.UserDao;
import com.example.demo.dto.UserDto;
import com.example.demo.languague.ErrorContent;
import com.example.demo.request.UserRegisterRequest;
import com.example.demo.response.Response;
import com.example.demo.security.JWTUtil;
import com.example.demo.service.UserService;
import com.example.demo.util.AppUtil;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserServiceImpl implements UserService  {
	 private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
    @Autowired
    UserController userController;

    @Override
    public JSONObject login(String username, String password) {
        try {
            UserDto user = userController.getDetail(username);
            if(user == null) {
                return Response.error(ErrorContent.USER_NOT_EXSIST.ordinal(), 1);
            }

            if(!user.getPassword().equals(password)) {
                return Response.error(ErrorContent.PASSWORD_WRONG.ordinal(), 1);
            }
            long t_time = 86400000;
            String token = JWTUtil.createJWT(String.valueOf(user.getId()), username, username, t_time);
            user.setToken(token);
            
            user = userController.save(user);
            if(user != null) {
                JSONObject data = new JSONObject();
                data.put("token", token);
                return Response.success(data);
            }

        } catch (Exception e) {
            logger.error(AppUtil.getStackTrace(e));
        }
        return Response.error(ErrorContent.ERROR.ordinal(), 1);
    }
    

    @Override
    public JSONObject register(UserRegisterRequest dataRequest) {
        try {
            UserDto user = userController.getDetail(dataRequest.getUsername());
            if(user != null) {
                return Response.error(ErrorContent.USER_IS_EXSIST.ordinal(), 1);
            }

            user = new UserDto();
            user.setDataRequest(dataRequest);
            user = userController.save(user);
            if(user != null) {
                JSONObject data = new JSONObject();
                return Response.success(data);
            }
            
        } catch (Exception e) {
            logger.error(AppUtil.getStackTrace(e));
        }
        return Response.error(ErrorContent.ERROR.ordinal(), 1);
    }

    
}
