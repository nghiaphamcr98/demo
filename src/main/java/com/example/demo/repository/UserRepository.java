package com.example.demo.repository;


import com.example.demo.Entity.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer>{
	
	@Query(nativeQuery = true, value = "SELECT u.* "
    		+ " FROM user u "
    		+ " WHERE u.username = :username "
    		+ " LIMIT 1")
    UserEntity getDetailUser(@Param("username") String username);
}
