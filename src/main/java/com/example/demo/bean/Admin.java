package com.example.demo.bean;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "tb_admin")
@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private  Integer adminId;
    private  String username;
    private  String password;
    private String name ;
    @Column(columnDefinition = "int default 2")
    private  Integer role;
}
