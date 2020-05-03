package com.example.demo.dao;

import java.util.List;

import com.example.demo.Entity.TagEntity;
import com.example.demo.repository.TagRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagDao {

    @Autowired
    TagRepository tagRepository;
    
    public TagEntity save(TagEntity questionAnswer) {
        return tagRepository.save(questionAnswer);
    }

    public Boolean existsById (int id) {
        return tagRepository.existsById(id);
    }

    public TagEntity getOne(int id) {
        return tagRepository.getOne(id);
    }

    public List<TagEntity> getAll(int from, int size) {
        return tagRepository.getAllTag(from, size);
    }

    public int countAll() {
        return tagRepository.countAllTag();
    }
    

}