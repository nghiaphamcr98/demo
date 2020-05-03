package com.example.demo.dao;

import java.util.List;

import com.example.demo.Entity.UserVoteEntity;
import com.example.demo.repository.UserVoteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserVoteDao {

    @Autowired
    UserVoteRepository userVoteRepository;
    
    public UserVoteEntity save(UserVoteEntity userVote) {
        return userVoteRepository.save(userVote);
    }

    public Boolean existsById (int id) {
        return userVoteRepository.existsById(id);
    }

    public UserVoteEntity getOne(int id) {
        return userVoteRepository.getOne(id);
    }

    public UserVoteEntity getOne(int user_id, int question_answer_id) {
        return userVoteRepository.getOne(user_id, question_answer_id);
    }

    public List<UserVoteEntity> getListByQuestionAnser(int question_answer_id, int status) { // status 2 get all, 1:upVote, 0:notthing, -1:downVote
        return userVoteRepository.getListByQuestionAnser(question_answer_id, status);
    }

    public int countListByQuestionAnser(int question_answer_id, int status) { // status 2 get all, 1:upVote, 0:notthing, -1:downVote
        return userVoteRepository.countListByQuestionAnser(question_answer_id, status);
    }
    

}