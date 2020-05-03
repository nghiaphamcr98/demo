package com.example.demo.dto;

import com.example.demo.Entity.UserVoteEntity;

public class UserVoteDto {

    private Integer id;
    private int user_id;
    private int question_anwser_id;
    private int status;

    public UserVoteDto() {

    }

    public UserVoteDto(UserVoteEntity userVote) {
        this.id = userVote.getId();
        this.question_anwser_id = userVote.getQuestion_anwser_id();
        this.user_id = userVote.getUser_id();
        this.status = userVote.getStatus();
    }

    public UserVoteDto(int user_id, int question_answer_id, int status) {
        this.id = 0;
        this.question_anwser_id = question_answer_id;
        this.user_id = user_id;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getQuestion_anwser_id() {
        return question_anwser_id;
    }

    public void setQuestion_anwser_id(int question_anwser_id) {
        this.question_anwser_id = question_anwser_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    

}