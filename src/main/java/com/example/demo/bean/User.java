package com.example.demo.bean;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "tb_user")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;
    private String username;
    private String password;
    private String name;
    @Column(name = "role_id")
    private  Integer roleId;
}
