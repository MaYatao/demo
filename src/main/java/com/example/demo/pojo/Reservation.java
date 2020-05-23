package com.example.demo.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * 预约实体
 */
@Data
@Table(name = "tb_reservation")
@Entity
public class Reservation {

    /**
     * 预约编号，主键ID自增
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "res_id")
    private Integer resId;

    /**
     * 预约操作日期
     */
    @Column(name = "opecra_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date opecraDate;

    /**
     * 预约就诊日期
     */
    @Column(name = "start_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;
    /**
     * 预约就诊日期
     */
    @Column(name = "end_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;


    /**
     * 预约患者
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 编号信息
     */
    @Column(name = "pd_id")
    private Integer pdId;

    /**
     * 0：未取号，1：已取号，2：已过期
     */
    @Column(name = "state")
    private Integer state;


}
