package com.example.demo.dao;

import java.util.List;

import com.example.demo.Entity.QuestionAnswerEntity;
import com.example.demo.repository.QuestionAnswerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionAnswerDao {

    @Autowired
    QuestionAnswerRepository questionAnswerRepository;
    
    public QuestionAnswerEntity save(QuestionAnswerEntity questionAnswer) {
        return questionAnswerRepository.save(questionAnswer);
    }

    public Boolean existsById (int id) {
        return questionAnswerRepository.existsById(id);
    }

    public QuestionAnswerEntity getOne(int id) {
        return questionAnswerRepository.getOne(id);
    }

    public List<QuestionAnswerEntity> getAll(int parent_id, int tag_id, int from, int size) {
        return questionAnswerRepository.getAllQuestionAnswerActive(parent_id, tag_id, from, size);
    }

    public int countAll(int parent_id, int tag_id) {
        return questionAnswerRepository.countAllQuestionAnswerActive(parent_id, tag_id);
    }
    

}