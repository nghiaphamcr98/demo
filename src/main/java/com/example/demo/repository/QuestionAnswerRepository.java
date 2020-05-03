package com.example.demo.repository;

import java.util.List;

import com.example.demo.Entity.QuestionAnswerEntity;

import org.json.simple.JSONObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface QuestionAnswerRepository extends JpaRepository<QuestionAnswerEntity, Integer>{
	
    @Query(nativeQuery = true, 
    value = "SELECT q.* "
        + " FROM question_answer q "
        + " LEFT JOIN tag_question tq ON tq.question_id = q.id "
        + " LEFT JOIN tag t ON tq.tag_id = t.id "
        + " WHERE q.status > 0 "
        + " AND q.parent_id = :parent_id"
        + " AND (t.id = :tag_id "
        + "    OR :tag_id = 0 ) "
        + " GROUP BY q.id "
        + " ORDER BY q.id DESC "
        + " LIMIT :from, :size "
        )
    List<QuestionAnswerEntity> getAllQuestionAnswerActive(@Param("parent_id") int parent_id, @Param("tag_id") int tag_id, @Param("from") int from, @Param("size") int size);

    @Query(nativeQuery = true, 
    value = "SELECT COUNT(DISTINCT q.id) "
        + " FROM question_answer q "
        + " LEFT JOIN tag_question tq ON tq.question_id = q.id "
        + " LEFT JOIN tag t ON tq.tag_id = t.id "
        + " WHERE q.status > 0 "
        + " AND q.parent_id = :parent_id"
        + " AND (t.id = :tag_id "
        + "    OR :tag_id = 0 ) "
        )
    int countAllQuestionAnswerActive(@Param("parent_id") int parent_id, @Param("tag_id") int tag_id);
}
