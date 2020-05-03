package com.example.demo.dto;

import com.example.demo.Entity.QuestionAnswerEntity;
import com.example.demo.request.QuestionAnswerAddNewRequest;

public class QuestionAnswerDto {

    private Integer id;
    private String content;
    private int status = 1;
    private int parent_id;

    public QuestionAnswerDto() {

    }

    public QuestionAnswerDto(QuestionAnswerEntity questionAnswer) {
        this.id = questionAnswer.getId();
        this.content = questionAnswer.getContent();
        this.status = questionAnswer.getStatus();
        this.parent_id = questionAnswer.getParent_id();
    }

    public void setDataRequest(QuestionAnswerAddNewRequest dataRequest) {
        this.content = dataRequest.getContent();
        this.parent_id = dataRequest.getQuestion_id();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }

 

}