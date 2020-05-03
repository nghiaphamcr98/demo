package com.example.demo.dao;

import java.util.List;

import com.example.demo.Entity.QuestionAnswerEntity;
import com.example.demo.Entity.TagQuestionEntity;
import com.example.demo.repository.QuestionAnswerRepository;
import com.example.demo.repository.TagQuestionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagQuestionDao {

    @Autowired
    TagQuestionRepository tagQuestionRepository;
    
    public TagQuestionEntity save(TagQuestionEntity tagQuestion) {
        return tagQuestionRepository.save(tagQuestion);
    }

    public Boolean existsById (int id) {
        return tagQuestionRepository.existsById(id);
    }

    public TagQuestionEntity getOne(int id) {
        return tagQuestionRepository.getOne(id);
    }

    public List<TagQuestionEntity> getAll(int question_id, int status) {
        return tagQuestionRepository.getAll(question_id, status); //status 2:get all, 1:active,  0:deactive
    }
    

}