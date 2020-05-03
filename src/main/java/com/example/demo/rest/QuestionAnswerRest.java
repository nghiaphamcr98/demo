package com.example.demo.rest;

import com.example.demo.request.QuestionAnswerAddNewRequest;
import com.example.demo.request.UpdateListStatusRequest;
import com.example.demo.request.UpdateStatusRequest;
import com.example.demo.request.UserRegisterRequest;
import com.example.demo.service.QuestionAnswerService;
import com.example.demo.service.UserService;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("/question_answer")
public class QuestionAnswerRest {

    @Autowired
    QuestionAnswerService questionAnswerService;

    @GetMapping("/question/get_all")
    public JSONObject get(
            @RequestParam int page,
            @RequestParam int tag_id //0: all, != fillter by tag_id
            ) {
        return questionAnswerService.getAllQuestion(page, tag_id);
    }

    @GetMapping("/answer/get_all")
    public JSONObject getAllAnswer(
            @RequestParam int question_id,
            @RequestParam int page
            ) {
        return questionAnswerService.getAllAnswer(question_id, page);
    }

    @PostMapping("/add_new")
    public JSONObject addNew(
            @RequestHeader("Authorization") String authorization,
            @RequestBody QuestionAnswerAddNewRequest data
            ) {
        return questionAnswerService.addNew(authorization, data);
    }

    @PostMapping("/update_status")
    public JSONObject updateStatus(
            @RequestHeader("Authorization") String authorization,
            @RequestBody UpdateListStatusRequest data
            ) {
        return questionAnswerService.updateStatus(authorization, data);
    }

    
    @PostMapping("/vote")
    public JSONObject vote(
            @RequestHeader("Authorization") String authorization,
            @RequestBody UpdateStatusRequest data
            ) {
        return questionAnswerService.vote(authorization, data);
    }


}