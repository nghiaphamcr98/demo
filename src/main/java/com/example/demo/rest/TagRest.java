package com.example.demo.rest;

import com.example.demo.request.TagAddNewRequest;
import com.example.demo.service.TagService;

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
@RequestMapping("/tag")
public class TagRest {

    @Autowired
    TagService tagService;

    @GetMapping("/get_all")
    public JSONObject get(
            @RequestParam int page
            ) {
        return tagService.getAll(page);
    }

    @PostMapping("/add_new")
    public JSONObject addNew(
        @RequestHeader("Authorization") String authorization,
            @RequestBody TagAddNewRequest data
            ) {
        return tagService.addNew(authorization, data);
    }

}