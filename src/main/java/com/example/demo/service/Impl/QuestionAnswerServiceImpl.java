package com.example.demo.service.Impl;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.config.Config;
import com.example.demo.controller.QuestionAnswerController;
import com.example.demo.controller.TagController;
import com.example.demo.controller.TagQuestionController;
import com.example.demo.controller.UserController;
import com.example.demo.controller.UserVoteController;
import com.example.demo.dto.QuestionAnswerDto;
import com.example.demo.dto.TagDto;
import com.example.demo.dto.TagQuestionDto;
import com.example.demo.dto.UserDto;
import com.example.demo.dto.UserVoteDto;
import com.example.demo.enums.EnumUserVoteStatus;
import com.example.demo.languague.ErrorContent;
import com.example.demo.request.QuestionAnswerAddNewRequest;
import com.example.demo.request.UpdateListStatusRequest;
import com.example.demo.request.UpdateStatusRequest;
import com.example.demo.response.AnswerGetAllResponse;
import com.example.demo.response.QuestionGetAllResponse;
import com.example.demo.response.Response;
import com.example.demo.response.TagGetAllResponse;
import com.example.demo.service.QuestionAnswerService;
import com.example.demo.util.AppUtil;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class QuestionAnswerServiceImpl implements QuestionAnswerService  {
	 private static final Logger logger = LoggerFactory.getLogger(QuestionAnswerServiceImpl.class);
	
    @Autowired
    QuestionAnswerController questionAnswerController;

    @Autowired
    UserController userController;

    @Autowired
    TagController tagController;

    @Autowired
    TagQuestionController tagQuestionController;

    @Autowired
    UserVoteController userVoteController;

    @Override
    public JSONObject getAllQuestion(int page, int tag_id) {
        try {
            int begin = AppUtil.getOffSetStart(page, Config.PAGE_SIZE);

            List<QuestionGetAllResponse> result = new ArrayList<>();
            int total = questionAnswerController.countAllQuestion(tag_id);
            List<QuestionAnswerDto> listQuestion = questionAnswerController.getAllQuestion(tag_id, begin, Config.PAGE_SIZE);
            for(QuestionAnswerDto question : listQuestion) {
                //vote // status 2 get all, 1:upVote, 0:notthing, -1:downVote
                int up_vote = userVoteController.countListByQuestionAnser(question.getId(), 1);
                int down_vote = userVoteController.countListByQuestionAnser(question.getId(), -1);

                QuestionGetAllResponse res = new QuestionGetAllResponse(question, up_vote, down_vote);

                List<TagQuestionDto> listTagQuestion = tagQuestionController.getAllTagQuestion(question.getId());
                for(TagQuestionDto tagQuestion : listTagQuestion) {
                    TagDto tag = tagController.getDetail(tagQuestion.getTag_id());
                    if(tag != null) {
                        TagGetAllResponse temp = new TagGetAllResponse(tag);
                        res.getList_tag().add(temp);
                    }
                }
                result.add(res);
            }
            
            JSONObject data = new JSONObject();
            data.put("question", result);
            data.put("total", total);
            data.put("size", Config.PAGE_SIZE);
            return Response.success(data);
        } catch (Exception e) {
            logger.error(AppUtil.getStackTrace(e));
        }
        return Response.error(ErrorContent.ERROR.ordinal(), 1);
    }

    @Override
    public JSONObject getAllAnswer(int question_id, int page) {
        try {
            int begin = AppUtil.getOffSetStart(page, Config.PAGE_SIZE);

            List<AnswerGetAllResponse> result = new ArrayList<>();
            int total = questionAnswerController.countAllAnswer(question_id);
            List<QuestionAnswerDto> listAnswer = questionAnswerController.getAllAnswer(question_id, begin, Config.PAGE_SIZE);
            for(QuestionAnswerDto answer : listAnswer) {
                //vote // status 2 get all, 1:upVote, 0:notthing, -1:downVote
                int up_vote = userVoteController.countListByQuestionAnser(answer.getId(), 1);
                int down_vote = userVoteController.countListByQuestionAnser(answer.getId(), -1);
    
                AnswerGetAllResponse res = new AnswerGetAllResponse(answer, up_vote, down_vote);
                result.add(res);
            }
            
            JSONObject data = new JSONObject();
            data.put("answer", result);
            data.put("total", total);
            data.put("size", Config.PAGE_SIZE);
            return Response.success(data);
        } catch (Exception e) {
            logger.error(AppUtil.getStackTrace(e));
        }
        return Response.error(ErrorContent.ERROR.ordinal(), 1);
    }

    @Override
    public JSONObject addNew(String token, QuestionAnswerAddNewRequest dataRequest) {
        try {
            //check
            if (!userController.validateUser(token)) {
                return Response.logout();
            }

            ErrorContent error = this.checkDataRequest(dataRequest);
            if(error != ErrorContent.SUCCESS) {
                return Response.error(error.ordinal(), 1);
            }

            //save question answer
            QuestionAnswerDto questionAnswer = new QuestionAnswerDto();
            questionAnswer.setDataRequest(dataRequest);
            questionAnswer = questionAnswerController.save(questionAnswer);
            if(questionAnswer == null) {
                return Response.error(ErrorContent.ERROR.ordinal(), 1);
            }

            //save tag_question
            if( dataRequest.getQuestion_id() == 0) {
                for(int tag_id : dataRequest.getList_tag_id()) {
                    TagQuestionDto tagQuestion = new TagQuestionDto(tag_id, questionAnswer.getId());
                    tagQuestion = tagQuestionController.save(tagQuestion);
                    if(tagQuestion == null) {
                        logger.error("error while save tag_question in addNewQuestionAnwser, question_id: " + questionAnswer.getId());
                    }
                }
            }

            JSONObject data = new JSONObject();
            return Response.success(data);
        } catch (Exception e) {
            logger.error(AppUtil.getStackTrace(e));
        }
        return Response.error(ErrorContent.ERROR.ordinal(), 1);
    }

    public ErrorContent checkDataRequest(QuestionAnswerAddNewRequest dataRequest) {
        try {
            //question = 0 => create question,  != => create answer by question
            if(dataRequest.getQuestion_id() != 0) {
                QuestionAnswerDto questionAnser = questionAnswerController.getDetail(dataRequest.getQuestion_id());
                if(questionAnser == null) {
                    return ErrorContent.QUESTION_NOT_EXSIST;
                }
                if(questionAnser.getStatus() < 1) {
                    return ErrorContent.QUESTION_NOT_OPEN;
                }
                
            } else {
                for(int tag_id : dataRequest.getList_tag_id()) {
                    TagDto tag = tagController.getDetail(tag_id);
                    if(tag == null) {
                        return ErrorContent.TAG_NOT_EXSIST;
                    }
                }
            }

            return ErrorContent.SUCCESS;
        } catch (Exception e) {
            logger.error(AppUtil.getStackTrace(e));
        }
        return ErrorContent.ERROR;
    }

    @Override
    public JSONObject updateStatus(String token, UpdateListStatusRequest dataRequest) {
        try {
            //check
            if (!userController.validateUser(token)) {
                return Response.logout();
            }
            List<Integer> fail_list = new ArrayList<>();

            for(int id : dataRequest.getList_id()) {
                QuestionAnswerDto questionAnswer = questionAnswerController.getDetail(id);
                if(questionAnswer == null) {
                    fail_list.add(id);
                    continue;
                }
                questionAnswer.setStatus(dataRequest.getStatus());
                questionAnswer = questionAnswerController.save(questionAnswer);
                if(questionAnswer == null) {
                    fail_list.add(id);
                    continue;
                }
            }
            if(dataRequest.getList_id().size() > fail_list.size() && dataRequest.getList_id().size() > 0) {
                JSONObject data = new JSONObject();
                data.put("fail_list", fail_list);
                return Response.success(data);
            }
        } catch (Exception e) {
            logger.error(AppUtil.getStackTrace(e));
        }
        return Response.error(ErrorContent.ERROR.ordinal(), 1);
    }

    @Override
    public JSONObject vote(String token, UpdateStatusRequest dataRequest) {
        try {
            //check
            if (!userController.validateUser(token)) {
                return Response.logout();
            }

            UserDto user = userController.getDetailByToken(token);
            if(user == null) {
                return Response.logout();
            }

            int status = dataRequest.getStatus();
            //logic
            QuestionAnswerDto questionAnswer = questionAnswerController.getDetail(dataRequest.getId());
            if(questionAnswer == null) {
                return Response.error(ErrorContent.QUESTION_ANSWER_NOT_EXSIST.ordinal(), 1);
            }

            UserVoteDto userVote = userVoteController.getDetail(user.getId(), questionAnswer.getId());
            if(userVote == null) { //create new vote
                userVote = new UserVoteDto(user.getId(),  questionAnswer.getId(), status);
            } else { //edit
                if( userVote.getStatus() == status) {
                    userVote.setStatus(EnumUserVoteStatus.NONE.getValue());
                } else {
                    userVote.setStatus(status);
                }
            }
            userVote = userVoteController.save(userVote);
            if(userVote != null) {
                JSONObject data = new JSONObject();
                return Response.success(data);
            } 
        } catch (Exception e) {
            logger.error(AppUtil.getStackTrace(e));
        }
        return Response.error(ErrorContent.ERROR.ordinal(), 1);
    }

    
}
