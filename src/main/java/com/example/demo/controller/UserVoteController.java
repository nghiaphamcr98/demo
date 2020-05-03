package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.Entity.TagQuestionEntity;
import com.example.demo.Entity.UserVoteEntity;
import com.example.demo.dao.TagQuestionDao;
import com.example.demo.dao.UserVoteDao;
import com.example.demo.dto.TagQuestionDto;
import com.example.demo.dto.UserVoteDto;
import com.example.demo.util.AppUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserVoteController {
    private static final Logger logger = LoggerFactory.getLogger(TagQuestionController.class);

    @Autowired
    UserVoteDao userVoteDao;

    public UserVoteDto save(UserVoteDto userVote) {
        try {
            UserVoteEntity result = new UserVoteEntity(userVote);
            result = userVoteDao.save(result);
            if(result != null) {
                return new UserVoteDto(result);
            }
        } catch (Exception e) {
            logger.error(AppUtil.getStackTrace(e));
        }
        return null;
    }

    public UserVoteDto getDetail(int id) {
        try {
            Boolean bool = userVoteDao.existsById(id);
            if(bool == true) {
                UserVoteEntity result = userVoteDao.getOne(id);
                return new UserVoteDto(result);
            }
        } catch (Exception e) {
            logger.error(AppUtil.getStackTrace(e));
        }
        return null;
    }

    public UserVoteDto getDetail(int user_id, int question_answer_id) {
        try {
            UserVoteEntity result = userVoteDao.getOne(user_id, question_answer_id);
            if(result != null) {
                return new UserVoteDto(result);
            }          
        } catch (Exception e) {
            logger.error(AppUtil.getStackTrace(e));
        }
        return null;
    }

    public List<UserVoteDto> getListByQuestionAnser(int question_answer_id, int status) {
        try {
            List<UserVoteDto> result = new ArrayList<>();
            
            List<UserVoteEntity> list = userVoteDao.getListByQuestionAnser(question_answer_id, status);   // status 2 get all, 1:upVote, 0:notthing, -1:downVote
            for(UserVoteEntity question : list) {
                UserVoteDto res =  new UserVoteDto(question);
                result.add(res);
            }
            return result;
        } catch (Exception e) {
            logger.error(AppUtil.getStackTrace(e));
        }
        return new ArrayList<>();
    }

    
    public int countListByQuestionAnser(int question_answer_id, int status) {
        try {
            return userVoteDao.countListByQuestionAnser(question_answer_id, status);   // status 2 get all, 1:upVote, 0:notthing, -1:downVote
        } catch (Exception e) {
            logger.error(AppUtil.getStackTrace(e));
        }
        return 0;
    }

}