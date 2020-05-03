package com.example.demo.response;

import com.example.demo.dto.QuestionAnswerDto;

public class AnswerGetAllResponse extends ContentResponse {

    private int id;
    private String content;
    private int question_id;

    public AnswerGetAllResponse() {

    }

    public AnswerGetAllResponse(QuestionAnswerDto answer, int up_vote, int down_vote) {
        super(answer, up_vote, down_vote);
        this.question_id = answer.getParent_id();
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
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

}