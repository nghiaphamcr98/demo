package com.example.demo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.demo.dto.UserDto;

@Entity
@Table(name ="user")
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
	@Column(name = "username")
    private String username;
    
    @Column(name = "password")
    private String password;

    @Column(name = "token")
    private String token = "";

    public UserEntity() {
        
    }

    public UserEntity(UserDto user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.token = user.getToken();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    
}