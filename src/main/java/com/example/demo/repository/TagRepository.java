package com.example.demo.repository;

import java.util.List;

import com.example.demo.Entity.TagEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface TagRepository extends JpaRepository<TagEntity, Integer>{
	
    @Query(nativeQuery = true, 
    value = "SELECT t.* "
        + " FROM tag t "
        + " GROUP BY t.id DESC "
		    + " LIMIT :from, :size ")
    List<TagEntity> getAllTag(@Param("from") int from, @Param("size") int size);

    @Query(nativeQuery = true, 
    value = "SELECT COUNT(t.id) "
    	  + " FROM tag t ")
    int countAllTag();
}
