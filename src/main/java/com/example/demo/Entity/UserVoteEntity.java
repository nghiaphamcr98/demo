package com.example.demo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.demo.dto.TagQuestionDto;
import com.example.demo.dto.UserVoteDto;

@Entity
@Table(name ="user_vote")
public class UserVoteEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
	@Column(name = "user_id")
    private int user_id;
    
    @Column(name = "question_anwser_id")
    private int question_anwser_id;

    @Column(name = "status")
    private int status;

    public UserVoteEntity() {
        
    }

    public UserVoteEntity(UserVoteDto userVote) {
        this.id = userVote.getId();
        this.question_anwser_id = userVote.getQuestion_anwser_id();
        this.user_id = userVote.getUser_id();
        this.status = userVote.getStatus();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getQuestion_anwser_id() {
        return question_anwser_id;
    }

    public void setQuestion_anwser_id(int question_anwser_id) {
        this.question_anwser_id = question_anwser_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    
    

  
}