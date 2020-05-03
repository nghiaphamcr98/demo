package com.example.demo.response;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.dto.QuestionAnswerDto;

public class QuestionGetAllResponse extends ContentResponse {

    private List<TagGetAllResponse> list_tag = new ArrayList<>();


    public QuestionGetAllResponse() {

    }

    public QuestionGetAllResponse(QuestionAnswerDto question, int up_vote, int down_vote) {
        super(question, up_vote, down_vote);
    }

    public List<TagGetAllResponse> getList_tag() {
        return list_tag;
    }

    public void setList_tag(List<TagGetAllResponse> list_tag) {
        this.list_tag = list_tag;
    }


}