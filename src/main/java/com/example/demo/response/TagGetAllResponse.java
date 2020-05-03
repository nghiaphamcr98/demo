package com.example.demo.response;

import com.example.demo.dto.TagDto;

public class TagGetAllResponse {

    private int id;
    private String name;

    public TagGetAllResponse() {

    }

    public TagGetAllResponse(TagDto tag) {
        this.id = tag.getId();
        this.name = tag.getName();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
}