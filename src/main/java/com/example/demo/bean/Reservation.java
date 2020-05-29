package com.example.demo.bean;

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
    private String opecraDate;

    /**
     * 预约就诊日期
     */
    @Column(name = "start_time")
    private String startTime;
    /**
     * 预约就诊日期
     */
    @Column(name = "end_time")
    private String endTime;

    private String stage; //上下午，值只有am,pm

    /**
     * 预约患者
     */
    @Column(name = "user_id")
    private Integer patientId;

    /**
     * 编号信息
     */
    @Column(name = "pd_id")
    private Integer pdId;

    /**
     * 编号信息
     */
    @Column(name = "doct_id")
    private Integer doctorId;
    /**
     * 0：未取号，1：已取号，2：已过期
     */
    @Column(name = "state")
    private Integer state;


}
