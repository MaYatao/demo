package com.example.demo.pojo;

import lombok.Data;

import javax.persistence.*;

/**
 * 医生类
 */
@Data
@Table(name = "tb_doctor")
@Entity
public class Doctor {
    /**
     * 医生主键ID自增
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doc_id")
    private Integer docId;

    /**
     * 医生姓名
     */
    private String docName;
    /**
     * 登陆密码
     */
    private String password;

    /**
     * 医生级别
     */
    private String level;

    /**
     * 是否专家，默认folse-非专家
     */
    @Column(name = "is_profession")
    private Boolean profession=false;

    /**
     * 所属科室
     */
    @Column(name = "dept_id")
    private Integer deptId;

    /**
     * 擅长什么
     */
    private String special;

    /**
     * 医生介绍
     */
    private String info;

    /**
     * 医生头像
     */
    @Column(name = "img_url")
    private String imgUrl;

    /**
     * 医生状态，-1作废，，0休假，1正常值班 ，2，管理员
     */
    private Integer state=1;

}
