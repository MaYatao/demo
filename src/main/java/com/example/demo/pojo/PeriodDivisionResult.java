package com.example.demo.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import java.util.Date;

@Data
public class PeriodDivisionResult {


    private Integer pdId;

    /**
     * 那一天
     */

    private String day;

    /**
     * 哪个时间段，'09:00-10:00
     */
    @Column(name = "time_div")
    private String timeDiv;

    private String stage;

    /**
     * 号源状态，0：停诊，1：空闲，2：已被预约
     */
    private Integer state=1;

    /**
     * 所属科室
     */
    private Integer deptId;
    private String deptName;
    /**
     * 对应的医生
     */
    private Integer doctorId;
    private String doctName;
    /**
     * 修改时间
     */
    private String modTime;
}
