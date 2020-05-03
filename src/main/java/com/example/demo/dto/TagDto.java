package com.example.demo.dto;

import com.example.demo.Entity.TagEntity;
import com.example.demo.request.TagAddNewRequest;

public class TagDto {

    private Integer id;
    private String name;

    public TagDto() {

    }

    public TagDto(TagEntity tag) {
        this.id = tag.getId();
        this.name =tag.getName();

    }

    public void setDataRequest(TagAddNewRequest dataRequest) {
        this.name = dataRequest.getName();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


 

}