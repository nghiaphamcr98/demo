package com.example.demo.request;

import java.util.List;

public class QuestionAnswerAddNewRequest {

    private String content;
    private int question_id; //question = 0 => create question,  != => create answer by question
    private List<Integer> list_tag_id;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public List<Integer> getList_tag_id() {
        return list_tag_id;
    }

    public void setList_tag_id(List<Integer> list_tag_id) {
        this.list_tag_id = list_tag_id;
    }

}