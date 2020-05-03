package com.example.demo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.demo.dto.QuestionAnswerDto;

@Entity
@Table(name ="question_answer")
public class QuestionAnswerEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
	@Column(name = "content")
    private String content;
    
    @Column(name = "status")
    private int status;

    @Column(name = "parent_id")
    private int parent_id;

    public QuestionAnswerEntity() {
        
    }

    public QuestionAnswerEntity(QuestionAnswerDto questionAnswer) {
        this.id = questionAnswer.getId();
        this.content = questionAnswer.getContent();
        this.status = questionAnswer.getStatus();
        this.parent_id = questionAnswer.getParent_id();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }

  
}