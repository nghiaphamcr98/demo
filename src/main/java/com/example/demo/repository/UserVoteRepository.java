package com.example.demo.repository;

import java.util.List;

import com.example.demo.Entity.UserVoteEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserVoteRepository extends JpaRepository<UserVoteEntity, Integer>{
	
    @Query(nativeQuery = true, 
    value = "SELECT uv.* "
        + " FROM user_vote uv "
        + " WHERE uv.question_anwser_id = :question_answer_id "
        + " AND ( :status = 2 "
        + "    OR uv.status = :status) " // status 2 get all, 1:upVote, 0:notthing, -1:downVote
        + " ORDER BY uv.id DESC "
        )
    List<UserVoteEntity> getListByQuestionAnser(@Param("question_answer_id") int question_answer_id, @Param("status") int status);

    @Query(nativeQuery = true, 
    value = "SELECT COUNT(uv.id) "
        + " FROM user_vote uv "
        + " WHERE uv.question_anwser_id = :question_answer_id "
        + " AND ( :status = 2 "
        + "    OR uv.status = :status) " // status 2 get all, 1:upVote, 0:notthing, -1:downVote
        )
    int countListByQuestionAnser(@Param("question_answer_id") int question_answer_id, @Param("status") int status);

    @Query(nativeQuery = true, 
    value = "SELECT uv.* "
        + " FROM user_vote uv "
        + " WHERE uv.question_anwser_id = :question_answer_id "
        + " AND uv.user_id = :user_id "
        )
    UserVoteEntity getOne(@Param("user_id") int user_id, @Param("question_answer_id") int question_answer_id);






}
