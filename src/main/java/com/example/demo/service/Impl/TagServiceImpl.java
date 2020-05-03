package com.example.demo.service.Impl;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.config.Config;
import com.example.demo.controller.TagController;
import com.example.demo.controller.UserController;
import com.example.demo.dto.TagDto;
import com.example.demo.languague.ErrorContent;
import com.example.demo.request.TagAddNewRequest;
import com.example.demo.response.Response;
import com.example.demo.response.TagGetAllResponse;
import com.example.demo.service.TagService;
import com.example.demo.util.AppUtil;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class TagServiceImpl implements TagService  {
	 private static final Logger logger = LoggerFactory.getLogger(TagServiceImpl.class);
	
    @Autowired
    TagController tagController;

    @Autowired
    UserController userController;

    @Override
    public JSONObject getAll(int page) {
        try {
            int begin = AppUtil.getOffSetStart(page, Config.PAGE_SIZE);

            List<TagGetAllResponse> result = new ArrayList<>();
            int total = tagController.countAll();
            List<TagDto> listTag = tagController.getAll(begin, Config.PAGE_SIZE);
            for(TagDto tag : listTag) {
                TagGetAllResponse res = new TagGetAllResponse(tag);
                result.add(res);
            }
            
            JSONObject data = new JSONObject();
            data.put("tag", result);
            data.put("total", total);
            data.put("size", Config.PAGE_SIZE);
            return Response.success(data);
        } catch (Exception e) {
            logger.error(AppUtil.getStackTrace(e));
        }
        return Response.error(ErrorContent.ERROR.ordinal(), 1);
    }

    @Override
    public JSONObject addNew(String token, TagAddNewRequest dataRequest) {
        try {
            if (!userController.validateUser(token)) {
                return Response.logout();
            }

            TagDto tag = new TagDto();
            tag.setDataRequest(dataRequest);
            
            tag = tagController.save(tag);
            if(tag != null) {
                JSONObject data = new JSONObject();
                return Response.success(data);
            }
        } catch (Exception e) {
            logger.error(AppUtil.getStackTrace(e));
        }
        return Response.error(ErrorContent.ERROR.ordinal(), 1);
    }
    

    
}
