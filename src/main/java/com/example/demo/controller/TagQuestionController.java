package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.Entity.TagQuestionEntity;
import com.example.demo.dao.TagQuestionDao;
import com.example.demo.dto.TagQuestionDto;
import com.example.demo.util.AppUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagQuestionController {
    private static final Logger logger = LoggerFactory.getLogger(TagQuestionController.class);

    @Autowired
    TagQuestionDao tagQuestionDao;

    public TagQuestionDto save(TagQuestionDto tagQuestion) {
        try {
            TagQuestionEntity result = new TagQuestionEntity(tagQuestion);
            result = tagQuestionDao.save(result);
            if(result != null) {
                return new TagQuestionDto(result);
            }
        } catch (Exception e) {
            logger.error(AppUtil.getStackTrace(e));
        }
        return null;
    }

    public TagQuestionDto getDetail(int id) {
        try {
            Boolean bool = tagQuestionDao.existsById(id);
            if(bool == true) {
                TagQuestionEntity result = tagQuestionDao.getOne(id);
                return new TagQuestionDto(result);
            }
        } catch (Exception e) {
            logger.error(AppUtil.getStackTrace(e));
        }
        return null;
    }

    public List<TagQuestionDto> getAllTagQuestion(int question_id) {
        try {
            List<TagQuestionDto> result = new ArrayList<>();
            
            List<TagQuestionEntity> list = tagQuestionDao.getAll(question_id, 1);   //status 2:get all, 1:active,  0:deactive
            for(TagQuestionEntity question : list) {
                TagQuestionDto res =  new TagQuestionDto(question);
                result.add(res);
            }
            return result;
        } catch (Exception e) {
            logger.error(AppUtil.getStackTrace(e));
        }
        return new ArrayList<>();
    }

}