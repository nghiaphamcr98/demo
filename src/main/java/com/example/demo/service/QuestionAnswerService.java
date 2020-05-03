package com.example.demo.service;

import com.example.demo.request.QuestionAnswerAddNewRequest;
import com.example.demo.request.UpdateListStatusRequest;
import com.example.demo.request.UpdateStatusRequest;

import org.json.simple.JSONObject;

public interface QuestionAnswerService {

    JSONObject getAllQuestion(int page, int tag_id);

    JSONObject getAllAnswer(int question_id, int page);

    JSONObject addNew(String token, QuestionAnswerAddNewRequest data);

    JSONObject updateStatus(String token, UpdateListStatusRequest data); //status = 0: deactive, 1:active

    JSONObject vote(String token, UpdateStatusRequest data); //status = 0: deactive, 1:active
}