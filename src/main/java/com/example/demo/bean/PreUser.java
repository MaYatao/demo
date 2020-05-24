package com.example.demo.bean;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * 预约患者类
 */
@Data
@Table(name = "tb_user")
@Entity
public class PreUser {
    /**
     * 患者主键ID自增
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 昵称
     */
    @Column(name = "login_name")
    private String loginName;

    /**
     * 真实姓名
     */
    @Column(name = "real_name")
    private String realName;

    /**
     * 登陆密码
     */
    private String password;

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

    /**
     * 注册日期
     */
    @Column(name = "reg_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date regDate;

    /**
     * 患者状态
     */
    private Integer state ;


}
