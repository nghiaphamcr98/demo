package com.example.demo.repository;

import java.util.List;

import com.example.demo.Entity.TagEntity;
import com.example.demo.Entity.TagQuestionEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface TagQuestionRepository extends JpaRepository<TagQuestionEntity, Integer>{
	
    @Query(nativeQuery = true, 
    value = "SELECT tq.* "
        + " FROM tag_question tq "
        + " WHERE tq.question_id = :question_id "
        + " AND ( :status = 2 "
        + "    OR tq.status = :status) " // status 2 get all, 1:active, 0:deactive
        + " ORDER BY tq.id DESC "
        )
    List<TagQuestionEntity> getAll(@Param("question_id") int question_id, @Param("status") int status);


}
