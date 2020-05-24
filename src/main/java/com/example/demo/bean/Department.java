package com.example.demo.bean;

import lombok.Data;

import javax.persistence.*;

/**
 * 科室实体类
 */
@Data
@Table(name = "tb_department")
@Entity
public class Department {
    /**
     * 科室主键ID自增
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dept_id")
    private Integer deptId;
    /**
     * 科室名称
     */
    @Column(name = "dept_name")
    private String deptName;

    /**
     * 科室地址
     */
    private String address;
    /**
     * 科室电话
     */
    private String telephone;
    /**
     * 科室介绍
     */
    private String info;
    /**
     * 科室图片地址
     */
    private String image;

    /**
     * 科室状态，0正常运行，1休整
     */
    private Integer state;

}
