package com.example.demo.dto;

import com.example.demo.Entity.TagQuestionEntity;

public class TagQuestionDto {

    private int id;
    private int tag_id;
    private int question_id;
    private int status;

    public TagQuestionDto() {
        this.status = 1;
    }

    public TagQuestionDto(int tag_id, int question_id) {
        this.id = 0;
        this.tag_id = tag_id;
        this.question_id = question_id;
        this.status = 1;
    }

    public TagQuestionDto(TagQuestionEntity tagQuestion) {
        this.id = tagQuestion.getId();
        this.tag_id = tagQuestion.getTag_id();
        this.question_id = tagQuestion.getQuestion_id();
        this.status = tagQuestion.getStatus();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTag_id() {
        return tag_id;
    }

    public void setTag_id(int tag_id) {
        this.tag_id = tag_id;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    

}