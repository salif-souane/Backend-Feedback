package com.cwa.springboot_app.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String role;

    public User(){}

    public User(Long id, String username, String password, String role){
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public String getUsername(){
        return this.username;
    }
    public void setUsername(String username){
        this.username = username;
    }

    public String getPassword(){
        return this.password;
    }
    public void setPassword(String password){
        this.password = password;
    }

    public String getRole(){
        return this.role;
    }
    public void setRole(String role){
        this.role = role;
    }
}
