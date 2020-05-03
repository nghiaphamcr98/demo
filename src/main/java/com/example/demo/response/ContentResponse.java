package com.example.demo.response;

import com.example.demo.dto.QuestionAnswerDto;

public class ContentResponse {

    private int id;
    private String content;
    private int up_vote;
    private int down_vote;

    public ContentResponse() {

    }
    public ContentResponse(QuestionAnswerDto question, int up_vote, int down_vote) {
        this.id = question.getId();
        this.content = question.getContent();
        this.up_vote = up_vote;
        this.down_vote = down_vote;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUp_vote() {
        return up_vote;
    }

    public void setUp_vote(int up_vote) {
        this.up_vote = up_vote;
    }

    public int getDown_vote() {
        return down_vote;
    }

    public void setDown_vote(int down_vote) {
        this.down_vote = down_vote;
    }

}