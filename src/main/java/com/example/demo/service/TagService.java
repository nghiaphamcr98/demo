package com.example.demo.service;

import com.example.demo.request.TagAddNewRequest;

import org.json.simple.JSONObject;

public interface TagService {

    JSONObject getAll(int page);

    JSONObject addNew(String token,TagAddNewRequest data);
}