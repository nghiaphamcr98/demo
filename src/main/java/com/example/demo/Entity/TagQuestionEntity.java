package com.example.demo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.demo.dto.TagQuestionDto;

@Entity
@Table(name ="tag_question")
public class TagQuestionEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
	@Column(name = "tag_id")
    private int tag_id;
    
    @Column(name = "question_id")
    private int question_id;

    @Column(name = "status")
    private int status = 1;

    public TagQuestionEntity() {
        
    }

    public TagQuestionEntity(TagQuestionDto tagQuestion) {
        this.id = tagQuestion.getId();
        this.tag_id = tagQuestion.getTag_id();
        this.question_id = tagQuestion.getQuestion_id();
        this.status = tagQuestion.getStatus();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getTag_id() {
        return tag_id;
    }

    public void setTag_id(int tag_id) {
        this.tag_id = tag_id;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    

  
}