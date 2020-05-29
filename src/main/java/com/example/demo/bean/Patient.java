package com.example.demo.bean;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * 预约患者类
 */
@Data
@Table(name = "tb_preuser")
@Entity
public class Patient {
    /**
     * 患者主键ID自增
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private Integer patientId;

    private Integer age;
    /**
     * 患者email
     */
    private String email;

    /**
     * 患者电话
     */
    private String phone;

    /**
     * 患者性别，默认为false-男
     */
    private Boolean sex ;

    /**
     * 患者身份证号
     */
    private String card;

    private String name;
    /**
     * 注册日期
     */
    @Column(name = "reg_date")
    private String regDate;

    /**
     * 患者状态
     */
    private Integer state ;


}
