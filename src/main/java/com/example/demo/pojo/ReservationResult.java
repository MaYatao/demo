package com.example.demo.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import java.util.Date;

@Data
public class ReservationResult {

    private Integer resId;

    /**
     * 预约操作日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date opecraDate;

    /**
     * 预约就诊日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;
    /**
     * 预约就诊日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;


    /**
     * 预约患者
     */
    private Integer userId;
    private String realname;

    /**
     * 编号信息
     */

    private Integer pdId;


    private Integer doct_id;
    private String doctName;
    /**
     * 0：未取号，1：已取号，2：已过期
     */

    private Integer state;


}
