package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.Entity.QuestionAnswerEntity;
import com.example.demo.dao.QuestionAnswerDao;
import com.example.demo.dto.QuestionAnswerDto;
import com.example.demo.util.AppUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionAnswerController {
    private static final Logger logger = LoggerFactory.getLogger(QuestionAnswerController.class);

    @Autowired
    QuestionAnswerDao questionAnswerDao;

    public QuestionAnswerDto save(QuestionAnswerDto questionAnswer) {
        try {
            QuestionAnswerEntity result = new QuestionAnswerEntity(questionAnswer);
            result = questionAnswerDao.save(result);
            if(result != null) {
                return new QuestionAnswerDto(result);
            }
        } catch (Exception e) {
            logger.error(AppUtil.getStackTrace(e));
        }
        return null;
    }

    public QuestionAnswerDto getDetail(int id) {
        try {
            Boolean bool = questionAnswerDao.existsById(id);
            if(bool == true) {
                QuestionAnswerEntity result = questionAnswerDao.getOne(id);
                return new QuestionAnswerDto(result);
            }
        } catch (Exception e) {
            logger.error(AppUtil.getStackTrace(e));
        }
        return null;
    }

    public List<QuestionAnswerDto> getAllQuestion(int tag_id, int from, int size) {
        try {
            List<QuestionAnswerDto> result = new ArrayList<>();
            
            List<QuestionAnswerEntity> list = questionAnswerDao.getAll(0, tag_id, from, size); // parent = 0: question
            for(QuestionAnswerEntity question : list) {
                QuestionAnswerDto res =  new QuestionAnswerDto(question);
                result.add(res);
            }
            return result;
        } catch (Exception e) {
            logger.error(AppUtil.getStackTrace(e));
        }
        return new ArrayList<>();
    }

    public int countAllQuestion(int tag_id) {
        try {
            return  questionAnswerDao.countAll(0, tag_id); // parent = 0: question
        } catch (Exception e) {
            logger.error(AppUtil.getStackTrace(e));
        }
        return 0;
    }

    public List<QuestionAnswerDto> getAllAnswer(int question_id, int from, int size) {
        try {
            List<QuestionAnswerDto> result = new ArrayList<>();
            
            List<QuestionAnswerEntity> list = questionAnswerDao.getAll(question_id, 0, from, size); // parent != 0: answer
            for(QuestionAnswerEntity answer : list) {
                QuestionAnswerDto res =  new QuestionAnswerDto(answer);
                result.add(res);
            }
            return result;
        } catch (Exception e) {
            logger.error(AppUtil.getStackTrace(e));
        }
        return new ArrayList<>();
    }

    public int countAllAnswer(int question_id) {
        try {
            return  questionAnswerDao.countAll(question_id, 0 ); // parent = 0: question
        } catch (Exception e) {
            logger.error(AppUtil.getStackTrace(e));
        }
        return 0;
    }

    

}