package com.example.demo.bean;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "tb_role")
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Integer roleId;
    @Column(name = "role_name")
    private String roleName;
}
