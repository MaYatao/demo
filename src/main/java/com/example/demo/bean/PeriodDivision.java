package com.example.demo.bean;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * 号源表
 */
@Data
@Table(name = "tb_period_division")
@Entity
public class PeriodDivision {
    /**
     * 号源编号自增
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pd_id")
    private Integer pdId;

    /**
     * 那一天
     */

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date day;

    /**
     * 哪个时间段，'09:00-10:00
     */
    @Column(name = "time_div")
    private String timeDiv;


    /**
     * 号源状态，0：停诊，1：空闲，2：已被预约
     */
    @Column(columnDefinition = "int default 1")
    private Integer state;

    /**
     * 所属科室
     */
    private Integer deptId;
    /**
     * 对应的医生
     */
    private Integer doctId;
    /**
     * 修改时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modTime;


}
