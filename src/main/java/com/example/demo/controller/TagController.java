package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.Entity.TagEntity;
import com.example.demo.dao.TagDao;
import com.example.demo.dto.TagDto;
import com.example.demo.util.AppUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagController {
    private static final Logger logger = LoggerFactory.getLogger(QuestionAnswerController.class);

    @Autowired
    TagDao tagDao;

    public TagDto save(TagDto tag) {
        try {
            TagEntity result = new TagEntity(tag);
            result = tagDao.save(result);
            if(result != null) {
                return new TagDto(result);
            }
        } catch (Exception e) {
            logger.error(AppUtil.getStackTrace(e));
        }
        return null;
    }

    public TagDto getDetail(int id) {
        try {
            Boolean bool = tagDao.existsById(id);
            if(bool == true) {
                TagEntity result = tagDao.getOne(id);
                return new TagDto(result);
            }
        } catch (Exception e) {
            logger.error(AppUtil.getStackTrace(e));
        }
        return null;
    }

    public List<TagDto> getAll(int from, int size) {
        try {
            List<TagDto> result = new ArrayList<>();
            
            List<TagEntity> list = tagDao.getAll(from, size);
            for(TagEntity tag : list) {
                TagDto res =  new TagDto(tag);
                result.add(res);
            }
            return result;
        } catch (Exception e) {
            logger.error(AppUtil.getStackTrace(e));
        }
        return new ArrayList<>();
    }

    public int countAll() {
        try {
            return  tagDao.countAll();
        } catch (Exception e) {
            logger.error(AppUtil.getStackTrace(e));
        }
        return 0;
    }



    

}